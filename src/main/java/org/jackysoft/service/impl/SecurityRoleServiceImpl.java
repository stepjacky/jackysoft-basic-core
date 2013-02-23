package org.jackysoft.service.impl;

import java.util.Collection;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.jackysoft.config.ResourceCache;
import org.jackysoft.entity.AcegiRole;
import org.jackysoft.entity.User;
import org.jackysoft.service.AbstractServiceImpl;
import org.jackysoft.service.SecurityRoleService;
import org.jackysoft.service.UserService;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;


@Service
@Transactional
public class SecurityRoleServiceImpl 
extends AbstractServiceImpl<String,AcegiRole>
implements SecurityRoleService,ApplicationContextAware{

	private UserService userService;
	private ResourceCache resourceCache;
	
	
	public SecurityRoleServiceImpl() {
		this.type = AcegiRole.class;
	}	
	
	@Override
	public Collection<AcegiRole> gets(User user)
			throws DataAccessException {
		Session sess = session();
		User u = (User) sess.get(User.class, user.getUsername());
		if(u==null) return Lists.newArrayList();
        return u.getAuthoritys();
	}

	

	public UserService getUserService() {
		return userService;
	}

	@Resource
	public void setUserService(UserService userService) {
		this.userService = userService;
	}	
	
	boolean hasRole(User user,AcegiRole role){
		if(role==null ) return false; 
			  // throw new IllegalArgumentException(" 角色不能为空 role "+ role);
		if(user==null) return false;
			  //throw new IllegalArgumentException(" 用户不能为空 usere "+ user);
		
		Collection<AcegiRole> roles = user.getAuthoritys();
		if(roles==null) return false;
		for(AcegiRole ar:roles){
			if(role.equals(ar)) return true;
		}
		return false;
		
	}

	
	

	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		try{
			resourceCache = applicationContext.getBean(ResourceCache.class);	
		}catch(NoSuchBeanDefinitionException e){
			resourceCache = null;
		}
		
		
	}
	
	void realoadResource(){
		if(resourceCache!=null)resourceCache.reloadResource();
	}

	@Override
	public int[] appendUsers(AcegiRole bean, Collection<User> users)
			throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[] updatePriority(Collection<AcegiRole> beans)
			throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}
   
}
