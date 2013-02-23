package org.jackysoft.service;

import java.util.Collection;

import org.jackysoft.entity.AcegiRole;
import org.jackysoft.entity.User;
import org.springframework.dao.DataAccessException;

public interface SecurityRoleService {
	
	Collection<AcegiRole> gets(User user) throws DataAccessException;
		
	int[] appendUsers(AcegiRole bean,Collection<User> users) throws DataAccessException;
	
	int[] updatePriority(Collection<AcegiRole> beans) throws DataAccessException;
	

}
