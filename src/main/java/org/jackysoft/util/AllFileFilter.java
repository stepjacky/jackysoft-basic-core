package org.jackysoft.util;

import java.io.File;
import java.io.FileFilter;

public class AllFileFilter implements FileFilter {

	@Override
	public boolean accept(File pathname) {
		if(pathname.isDirectory()) return false;
		return true;
	}

}
