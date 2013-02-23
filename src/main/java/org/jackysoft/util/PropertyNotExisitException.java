package org.jackysoft.util;

public class PropertyNotExisitException extends NullPointerException {

	public PropertyNotExisitException(String s) {
		super("属性 : "+s+" 没有找到");
		// TODO Auto-generated constructor stub
	}

}
