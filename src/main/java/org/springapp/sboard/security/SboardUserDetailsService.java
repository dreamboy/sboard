package org.springapp.sboard.security;

import org.springapp.sboard.user.domain.User;
import org.springapp.sboard.user.service.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SboardUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		User user = repository.findByUserid(username);
		
		if(user == null) {
			throw new UsernameNotFoundException(username);
		}
		return new SboardUserDetails(user);
	}
	

}
