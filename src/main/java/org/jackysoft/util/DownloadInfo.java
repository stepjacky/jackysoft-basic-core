package org.jackysoft.util;


public class DownloadInfo {
    protected byte[] content;
    protected String fileName;
    protected long length;
    
	public DownloadInfo() {
		super();
	}
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public long getLength() {
		
		return length;
	}
	public void setLength(long length) {
		this.length = length;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}
    
}
