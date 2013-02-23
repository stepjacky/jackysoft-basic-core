package org.jackysoft.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class IgnoreDtdValidateResolver implements EntityResolver {

	public InputSource resolveEntity(String publicId, String systemId)
			throws SAXException, IOException {
		/*
		 * if( "http://www.opensymphony.com/osworkflow/workflow_2_7.dtd"
		 * .equalsIgnoreCase(systemId)
		 * ||"http://www.opensymphony.com/osworkflow/workflow_2_8.dtd"
		 * .equalsIgnoreCase(systemId)) return new InputSource(new
		 * ByteArrayInputStream("<?xml version=\"1.0\"
		 * encoding=\"UTF-8\"?>".getBytes())); else return null;
		 */
		return new InputSource(new ByteArrayInputStream(
				"<?xml version=\"1.0\" encoding=\"UTF-8\"?>".getBytes()));
	}

}
