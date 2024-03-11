package com.myblogapi.security;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.myblogapi.entity.Role;
import com.myblogapi.entity.User;
import com.myblogapi.exception.UserNameNotFoundException;
import com.myblogapi.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	
	
	
	
	
	private UserRepository userRepo;
	
	@Autowired
	public CustomUserDetailsService(UserRepository userRepo) {
		this.userRepo = userRepo;
	}

	@Override
	public UserDetails loadUserByUsername(String usernameorEmail) throws UsernameNotFoundException {
		User user = userRepo.findByUserNameOrEmail(usernameorEmail, usernameorEmail)
		.orElseThrow(()->
			new UserNameNotFoundException("User not found with this email or username : "+usernameorEmail)
		);
		
		
		return new org.springframework.security.core.userdetails.User(user.getUserName(),user.getPassword(),mapRolesToAuthorities(user.getRoles()));
	}
	
	private Collection< ? extends GrantedAuthority> mapRolesToAuthorities(Set<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }


}
