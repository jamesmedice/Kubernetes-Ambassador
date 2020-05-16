package com.medici.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.medici.model.OauthUser;
import com.medici.repository.OauthUserRepository;

/**
 * 
 * @author a73s
 *
 */
@Component
@Qualifier("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private OauthUserRepository oauthRepository;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		OauthUser oauthDetails = oauthRepository.findByUsername(username);
		return oauthDetails;
	}
}
