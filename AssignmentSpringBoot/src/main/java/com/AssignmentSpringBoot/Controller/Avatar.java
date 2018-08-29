package com.AssignmentSpringBoot.Controller;

import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.AssignmentSpringBoot.Service.CustomUser;

@Component(value="useravatar")
@Scope("session")
public class Avatar {

	public String getUserAvatar() {
		CustomUser user = (CustomUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return user.getAvatar();
	}
}
