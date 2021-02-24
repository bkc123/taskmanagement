
package com.hcl.taskmanagement.service;

import com.hcl.taskmanagement.model.User;
import com.hcl.taskmanagement.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepo repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<User> user = repo.findByUsername(username);
		if (user == null)
			throw new UsernameNotFoundException("User 404");

		return user.map(UserPrincipal::new).get();
	}

}
