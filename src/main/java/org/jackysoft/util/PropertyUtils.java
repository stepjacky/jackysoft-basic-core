package org.jackysoft.util;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.DefaultPropertiesPersister;
import org.springframework.util.PropertiesPersister;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PropertyUtils {
	private static final String DEFAULT_ENCODING = "UTF-8";

	private static Log logger = LogFactory.getLog(PropertyUtils.class);

	private static PropertiesPersister propertiesPersister = new DefaultPropertiesPersister();

	/**
	 * 载入多个ClassPath中的properties文件, 相同的属性将会覆盖之前的载入.
	 * @see org.springframework.beans.factory.config.PropertyPlaceholderConfigurer
	 */
	public static Properties loadProperties(String... locations) throws IOException {
		Properties props = new Properties();

		for (String location : locations) {

			logger.debug("Loading properties file from classpath:" + location);

			InputStream is = null;
			try {
				Resource resource = new ClassPathResource(location);
				is = resource.getInputStream();
				propertiesPersister.load(props, new InputStreamReader(is, DEFAULT_ENCODING));
			} catch (IOException ex) {
				logger.info("Could not load properties from classpath:" + location + ": " + ex.getMessage());
			} finally {
				if (is != null) {
					is.close();
				}
			}
		}
		return props;
	}

}
