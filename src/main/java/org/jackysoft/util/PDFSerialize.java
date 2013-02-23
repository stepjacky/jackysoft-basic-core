package org.jackysoft.util;

public class PDFSerialize {

	private String pdfName;
	private String data;
	private String ext;

	public PDFSerialize(String pdfName, String data,String ext) {
		super();
		this.pdfName = pdfName;
		this.data = data;
		this.ext = ext;
	}

	public String getPdfName() {
		return pdfName;
	}

	public void setPdfName(String pdfName) {
		this.pdfName = pdfName;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}

	public String getExt() {
		return ext;
	}
}
