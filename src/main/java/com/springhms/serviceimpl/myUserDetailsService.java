package com.springhms.serviceimpl;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.springhms.model.user;
import com.springhms.repository.userRepository;

@Service
public class myUserDetailsService implements UserDetailsService {
	
	//Here we performed dependency injection
	@Autowired
	private userRepository userepo;
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		user u1=userepo.findByUserName(username);
		
		return new org.springframework.security.core.userdetails
				.User(u1.getUserName(), u1.getUserPassword(), new ArrayList<>());
		
	}

}
