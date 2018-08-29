package com.AssignmentSpringBoot.Service;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class CustomUser extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String avatar;
	
	public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities, String avatar) {
		super(username, password, authorities);
		this.avatar = avatar;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	
}
