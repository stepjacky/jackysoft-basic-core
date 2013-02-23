package org.jackysoft.util;

import java.io.File;

public class CustomFile extends File{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3009819482448647809L;
    private String titleName;
	public CustomFile(String pathname,String fileName) {
		super(pathname);	
		titleName = fileName;
	}
	public String getTitleName() {
	    return titleName;
	}
	
	
}