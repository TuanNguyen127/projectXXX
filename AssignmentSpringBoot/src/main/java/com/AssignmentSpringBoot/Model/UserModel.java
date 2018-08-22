package com.AssignmentSpringBoot.Model;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

import com.AssignmentSpringBoot.Entity.User;

public class UserModel implements Serializable{

	private static final long serialVersionUID = 1L;
	private User user;
	private MultipartFile multipartFile;
	
	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public MultipartFile getMultipartFile() {
	    return multipartFile;
	}
	
	public void setMultipartFile(MultipartFile multipartFile) {
	  this.multipartFile = multipartFile;
	}

}
