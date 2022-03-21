package com.ZuuleGateway.Service;



import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ZuuleGateway.Repo.UserRepo;

@Component
@Service
public class CustomUserdetailsService implements UserDetailsService {
	
	@Autowired
    private UserRepo userrepo;


	@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
   com.ZuuleGateway.JwtModel.User user = userrepo.findByUserName(username);
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), new ArrayList<>());
    }
}
