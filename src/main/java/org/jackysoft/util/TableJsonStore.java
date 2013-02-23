package org.jackysoft.util;


public class TableJsonStore {
	private String pager;
	private String list;

	public TableJsonStore setPager(String pager) {
		this.pager = pager;
		return this;
	}

	public TableJsonStore setList(String list) {
		this.list = list;
		return this;
	}

	@Override
	public String toString(){
		 StringBuilder jsons = new StringBuilder("{\"page\":");
		    jsons.append(pager);
		    jsons.append(",\"list\":");
		    jsons.append(list);
		    jsons.append("}");
		return jsons.toString();
		
	}
}
