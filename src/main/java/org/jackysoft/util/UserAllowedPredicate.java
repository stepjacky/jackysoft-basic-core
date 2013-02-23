package org.jackysoft.util;

import org.jackysoft.entity.User;

import com.google.common.base.Predicate;

public class UserAllowedPredicate implements Predicate<User> {

	private boolean enabled = true;
	
	public UserAllowedPredicate() {
		super();	
		this.enabled = true;
	}

	/**
	 * @param enabled 用户是否启用
	 * */
	public UserAllowedPredicate(boolean enabled) {
		this();
		this.enabled = enabled;
	}

	@Override
	public boolean apply(User input) {
		return input.isEnabled();
	}

}
