package org.jackysoft.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.tools.zip.ZipOutputStream;

public final class IOUtils extends org.apache.commons.io.IOUtils {

	static final Log log = LogFactory.getLog(IOUtils.class);

	public static InputStream toInputStream(byte[] content) {
		ByteArrayInputStream bis = new ByteArrayInputStream(content);
		return bis;
	}

	public static byte[] toByteArray(File source) {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		InputStream ins;
		try {
			ins = new FileInputStream(source);
			byte[] buffer = new byte[1024];
			int d = -1;
			while ((d = ins.read(buffer)) != -1) {
				bos.write(buffer,0,d);
			}
			ins.close();
		} catch (FileNotFoundException e) {
			log.error(e);
			e.printStackTrace();
		} catch (IOException e) {
			log.error(e);
			e.printStackTrace();
		}

		return bos.toByteArray();
	}

	public static void saveFile(File source, File target) {
		try {
			BufferedOutputStream bw = new BufferedOutputStream(
					new FileOutputStream(target));
			BufferedInputStream bis = new BufferedInputStream(
					new FileInputStream(source));

			int data = -1;
			byte[] buf = new byte[2048];
			while ((data = bis.read(buf)) != -1) {
				bw.write(buf, 0, data);
			}
			bw.close();
			bis.close();
		} catch (FileNotFoundException e) {
			log.error(e);
			e.printStackTrace();
		} catch (IOException e) {
			log.error(e);
			e.printStackTrace();
		}

	}

	public static void saveFile(byte[] source, File target) {
		try {
			BufferedOutputStream bw = new BufferedOutputStream(
					new FileOutputStream(target));
			BufferedInputStream bis =  new BufferedInputStream(new ByteArrayInputStream(source));

			int data = -1;
			byte[] buf = new byte[2048];
			while ((data = bis.read(buf)) != -1) {
				bw.write(buf, 0, data);

			}
			bw.close();
			bis.close();
		} catch (FileNotFoundException e) {
			log.error(e);
			e.printStackTrace();
		} catch (IOException e) {
			log.error(e);
			e.printStackTrace();
		}

	}

	/**
	 * 把一组文件压缩成一个字节数组
	 * 
	 * @param 文件集合
	 * @return 文件字节数组
	 * */
	public static byte[] zipFiles(Collection<File> files) {
		byte[] bs = new byte[0];
		String baseDir = System.getProperty("java.io.tmpdir") + File.separator;
		UUID uid = UUID.randomUUID();
		String fileName = baseDir + uid.toString() + ".zip";
		try {
			ZipOutputStream out = new ZipOutputStream(new FileOutputStream(
					fileName));
			out.setEncoding("UTF-8");
			for (File f : files) {
				String name = f.getName();
				if (f instanceof CustomFile) {
					CustomFile cf = (CustomFile) f;
					name = cf.getTitleName();

				}
				out.putNextEntry(new org.apache.tools.zip.ZipEntry(name));
				FileInputStream in = new FileInputStream(f);
				int b;
				while ((b = in.read()) != -1) {
					out.write(b);
				}
				in.close();
			}
			out.close();
			bs = IOUtils.toByteArray(new FileInputStream(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bs;
	}

}
