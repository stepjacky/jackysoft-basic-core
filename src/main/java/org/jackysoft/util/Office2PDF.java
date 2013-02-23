package org.jackysoft.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringWriter;
import java.net.Socket;
import java.util.UUID;
import java.util.concurrent.Callable;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Office2PDF implements Callable<String> {
	
	static final Log log = LogFactory.getLog(Office2PDF.class);
	static Socket server;
	
	private String ext;
	private byte[] data;
	private int port;
	private String host;
	
	/**
	 * @param host 主机
	 * @param port 端口
	 * @param ext 扩展名
	 * @param data 数据
	 * */
	public Office2PDF(String host,int port,String ext,byte[] data){
		this.host = host;
		this.port = port;
		this.ext = ext;
		this.data = data;
	}
	
	@Override
	public String call() throws Exception {
		UUID uuid = UUID.randomUUID();
		String pdfName = uuid.toString();
		PDFSerialize pdf = new PDFSerialize(pdfName, EncodeUtils.base64Encode(data),ext);
		StringWriter writer = new StringWriter();
		GsonBuilder gb = new GsonBuilder();
		Gson gson = gb.create();
		gson.toJson(pdf, writer);
		try {
			log.info("连接到服务器 :"+host+" 端口: "+port);
			server = new Socket(host, port);
			OutputStream socketOut = server.getOutputStream();
			byte[] ds = writer.toString().getBytes();
			ByteArrayInputStream bis = new ByteArrayInputStream(ds);
			byte[] buf = new byte[1024];
			int read = 0;
			while ((read = bis.read(buf)) != -1) {
				socketOut.write(buf, 0, read);
			}
			socketOut.close();
            server.close();
            log.info("数据传送完毕,连接关闭");
		} catch (IOException e) {
			log.error(e);
		}
		return pdfName;
	}

}
