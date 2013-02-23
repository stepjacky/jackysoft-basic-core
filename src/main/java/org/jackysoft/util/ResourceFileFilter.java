package org.jackysoft.util;

import java.io.File;
import java.io.FileFilter;

public class ResourceFileFilter implements FileFilter {
	private String type;

	public ResourceFileFilter(String type) {
		if (type == null)
			throw new ResourceTypeMissedException();
		this.type = type;
	}

	@Override
	public boolean accept(File pathname) {
		if (pathname.isDirectory())
			return false;
		String ext = pathname.getName().substring(
				pathname.getName().lastIndexOf('.') + 1);
		if (!this.type.equalsIgnoreCase(ext))
			return false;
		return true;
	}
}
