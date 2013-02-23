package org.jackysoft.collection.function;

import java.util.Map;

import com.google.common.collect.Maps;

public class TreeItem {
	private String name;
	private String text;
	private boolean parent = false;
	private Map<String, String> attr = Maps.newHashMap();

	

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Map<String, String> getAttr() {
		return attr;
	}

	public void setAttr(Map<String, String> attr) {
		this.attr = attr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isParent() {
		return parent;
	}

	public void setParent(boolean parent) {
		this.parent = parent;
	}

}
