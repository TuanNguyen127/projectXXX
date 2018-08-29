package com.AssignmentSpringBoot.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.AssignmentSpringBoot.Repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userAccountRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<com.AssignmentSpringBoot.Entity.User> uaList = userAccountRepo.findByUsername(username);
		if(uaList == null || uaList.isEmpty()) {
			System.out.println("Không tìm thấy user!");
			throw new UsernameNotFoundException("User " + username + " was not found on the database");
		}
		com.AssignmentSpringBoot.Entity.User ua = uaList.get(0);
		System.out.println("found user " + ua);
		GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_"+ua.getRole());
		List<GrantedAuthority> grantList = new ArrayList<>();
		grantList.add(authority);
		UserDetails userDetail = new CustomUser(ua.getUsername(),ua.getPassword(),grantList,ua.getAvatar());
		return userDetail;
	}

}
