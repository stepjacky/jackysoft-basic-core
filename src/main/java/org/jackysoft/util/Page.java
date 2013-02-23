package org.jackysoft.util;


public class Page {
	
	private String page;
	
	private String total;
	
	private String records;
	
	private Iterable<?> rows;

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getRecords() {
		return records;
	}

	public void setRecords(String records) {
		this.records = records;
	}

	public Iterable<?> getRows() {
		return rows;
	}

	public void setRows(Iterable<?> rows) {
		this.rows = rows;
	}

	

}
