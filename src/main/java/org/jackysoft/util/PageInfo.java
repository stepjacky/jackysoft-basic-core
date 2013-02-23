package org.jackysoft.util;

import java.io.Serializable;

public class PageInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3676861919249342185L;
	private int rowCount;
	private int rowsInPage;
	private int pageIndex;
	private int pageCount;
	private int startIndex;
	
	
	public int getRowCount() {
		return rowCount;
	}
	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}
	public int getRowsInPage() {
		return rowsInPage;
	}
	public void setRowsInPage(int rowsInPage) {
		this.rowsInPage = rowsInPage;
	}
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	
	
	
	
	
	
}
