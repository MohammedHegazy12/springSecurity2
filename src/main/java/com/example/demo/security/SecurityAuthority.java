package com.example.demo.security;

import org.springframework.security.core.GrantedAuthority;

import com.example.demo.entity.Authority;

public class SecurityAuthority implements GrantedAuthority {
	
	private final Authority authority;
	
	
	public SecurityAuthority(Authority authority) {
		super();
		this.authority = authority;
	}


	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return authority.getName();
	}

}
