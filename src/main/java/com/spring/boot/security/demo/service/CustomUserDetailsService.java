package com.spring.boot.security.demo.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.boot.security.demo.entity.UserEntity;
import com.spring.boot.security.demo.repository.UserRepository;

@Service
public class CustomUserDetailsService  implements UserDetailsService{
	
	private UserRepository userRepository;
	
	public CustomUserDetailsService(UserRepository userRepository) {
		this.userRepository=userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		UserEntity user =userRepository.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("User not found: "+username));
		return user;
	}
	

}
