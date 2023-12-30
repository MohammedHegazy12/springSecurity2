package com.example.demo.services;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repositories.UserRepository;
import com.example.demo.security.SecurityUser;

@Service
public class JpaUserDetailsService implements UserDetailsService{
	
	private final UserRepository userRepository;
	
	
	public JpaUserDetailsService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}


	@Override
	public UserDetails loadUserByUsername(String username)   {
		// TODO Auto-generated method stub
		Optional<User>user=userRepository.findByUsername(username) ;
		
		return user.
map(SecurityUser::new).orElseThrow(()->new UsernameNotFoundException("Username not found".concat(username)));
	}

}
