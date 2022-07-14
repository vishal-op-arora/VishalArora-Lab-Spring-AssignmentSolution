package io.vishal.studentapi.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import io.vishal.studentapi.model.DomainUserDetails;
import io.vishal.studentapi.model.User;
import io.vishal.studentapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DomainUserDetailService implements UserDetailsService{

	private final UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
				
		User user = this.userRepository.findByUserName(username).orElseThrow(() -> new UsernameNotFoundException("Invalid User"));
		
		return new DomainUserDetails(user);
	}
	
	
}
