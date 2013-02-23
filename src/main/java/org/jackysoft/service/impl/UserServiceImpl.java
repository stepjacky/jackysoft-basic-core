package org.jackysoft.service.impl;

import java.util.Collection;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.criterion.Property;
import org.jackysoft.collection.function.TreeItem;
import org.jackysoft.collection.function.UserFunction;
import org.jackysoft.entity.Department;
import org.jackysoft.entity.User;
import org.jackysoft.service.AbstractServiceImpl;
import org.jackysoft.service.UserService;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Collections2;

@Service
@Transactional

public class UserServiceImpl extends AbstractServiceImpl<String,User> implements
		UserService {

	
	protected final Log log = LogFactory.getLog(UserServiceImpl.class);
	
	public UserServiceImpl() {
		this.type = User.class;
	}

	@Override
	public Collection<TreeItem> getsByParent(Department dept)
			throws DataAccessException {
		Property department = Property.forName("department");
		Criteria crit = session().createCriteria(getType());
		crit.add(department.eq(dept));
		List<User> users = crit.list();
		Collection<TreeItem>  items = Collections2.transform(users, new UserFunction());
		return items;
	}

	
	
}
