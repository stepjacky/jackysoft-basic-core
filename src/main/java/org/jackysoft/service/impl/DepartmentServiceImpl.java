package org.jackysoft.service.impl;

import java.util.Collection;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

import org.hibernate.Criteria;
import org.hibernate.criterion.Property;
import org.jackysoft.collection.function.DepartmentFunction;
import org.jackysoft.collection.function.TreeItem;
import org.jackysoft.entity.Department;
import org.jackysoft.service.AbstractServiceImpl;
import org.jackysoft.service.DepartmentService;
import org.jackysoft.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;

@Service
@Transactional("transactionManager")
public class DepartmentServiceImpl extends
		AbstractServiceImpl<String, Department> implements DepartmentService {

	private UserService userService;

	public DepartmentServiceImpl() {
		this.type = Department.class;
	}

	@Override
	public Collection<TreeItem> getsByParent(String id) {
		Property parent = Property.forName("parent");
		Criteria crit = session().createCriteria(getType());
		crit.add(parent.eq(new Department(id)));
		List<Department> users = crit.list();
		Collection<TreeItem> allItems = Lists.newArrayList();
		Collection<TreeItem> items = Collections2.transform(users,
				new DepartmentFunction());
		allItems.addAll(items);
		items = userService.getsByParent(new Department(id));
		allItems.addAll(items);
		return allItems;
	}

	@Override
	public Department fetchDepartment(Department dept) {

		Stack<String> stk = new Stack<String>();
		Department parent = getParent(dept);
		stk.push(parent.getName());
		while (parent != null) {
			parent = getParent(parent);
			stk.push(parent.getName());
		}
		String name = "";
		String tname = "";
		try {
			while ((tname = stk.pop()) != null) {
				name += tname + " ";
			}
		} catch (EmptyStackException e) {
            log.error(e.getMessage(), e);
		}

		return new Department(dept.getId(), name);
	}

	@Override
	public Department getParent(Department parent) {
		Department im = get(parent.getId());
		return im.getParent();
	}

}
