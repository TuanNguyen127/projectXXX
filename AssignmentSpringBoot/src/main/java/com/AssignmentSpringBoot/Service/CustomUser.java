package com.AssignmentSpringBoot.Service;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class CustomUser extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private com.AssignmentSpringBoot.Entity.User user;
	
	public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities, com.AssignmentSpringBoot.Entity.User user) {
		super(username, password, authorities);
		this.user = user;
	}

	public com.AssignmentSpringBoot.Entity.User getUser() {
		return user;
	}

	public void setUser(com.AssignmentSpringBoot.Entity.User user) {
		this.user = user;
	}
}
