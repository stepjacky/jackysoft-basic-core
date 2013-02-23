package org.jackysoft.service;

import java.util.Collection;

import org.jackysoft.collection.function.TreeItem;
import org.jackysoft.entity.Department;
import org.jackysoft.entity.User;
import org.springframework.dao.DataAccessException;

public interface UserService extends CRUDDataProvider<String,User> {
	
	Collection<TreeItem> getsByParent(Department dept) throws DataAccessException;
	
}
