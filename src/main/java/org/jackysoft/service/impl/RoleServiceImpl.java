package org.jackysoft.service.impl;

import org.jackysoft.entity.Role;
import org.jackysoft.service.AbstractServiceImpl;
import org.jackysoft.service.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class RoleServiceImpl 
extends AbstractServiceImpl<String,Role>
implements RoleService{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1013363302629976859L;

	public RoleServiceImpl() {
		this.type = Role.class;
	}

	
}
