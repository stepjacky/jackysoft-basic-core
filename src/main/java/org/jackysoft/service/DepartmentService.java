package org.jackysoft.service;

import java.util.Collection;

import org.jackysoft.collection.function.TreeItem;
import org.jackysoft.entity.Department;

public interface DepartmentService {
	 Collection<TreeItem> getsByParent(String id) ;	
	 Department getParent(Department parent);
	 public Department fetchDepartment(Department dept);
}