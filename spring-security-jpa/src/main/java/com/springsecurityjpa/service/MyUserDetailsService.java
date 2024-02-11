package com.springsecurityjpa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springsecurityjpa.models.MyUserDetails;
import com.springsecurityjpa.models.User;
import com.springsecurityjpa.repository.UserRepositoy;

@Service
public class MyUserDetailsService implements UserDetailsService {

  @Autowired
  UserRepositoy userRepositoy;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      Optional<User> user = userRepositoy.findByUserName(username);
      user.orElseThrow(()-> new UsernameNotFoundException("User not found"));
      return user.map(MyUserDetails::new).get();
      
    }

    
}
