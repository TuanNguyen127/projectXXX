package com.AssignmentSpringBoot.Service;

import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.AssignmentSpringBoot.Entity.User;

@Component(value="loggedinuser")
@Scope("session")
public class LoggedInUser {

	public User getUser() {
		CustomUser user = (CustomUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return user.getUser();
	}
}
