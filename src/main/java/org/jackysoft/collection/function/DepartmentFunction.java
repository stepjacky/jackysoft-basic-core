package org.jackysoft.collection.function;

import org.jackysoft.entity.Department;

public class DepartmentFunction extends
		AbstractGoogleFunction<Department, TreeItem> {

	@Override
	public TreeItem apply(Department input) {
		TreeItem item = new TreeItem();
		item.setName(input.getId());
		item.setText(input.getName());
		item.setParent(true);
		return item;
	}

}
