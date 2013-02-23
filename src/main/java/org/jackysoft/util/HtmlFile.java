package org.jackysoft.util;

public final class HtmlFile {
	String fileName;
    byte[] data;
    
    
	public HtmlFile() {
		
	}
    public HtmlFile(String f,byte[] d) {
		this.fileName = f;
		this.data = d;
	}
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public byte[] getData() {
		return data;
	}
	public void setData(byte[] data) {
		this.data = data;
	}
    
}