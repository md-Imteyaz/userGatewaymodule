package com.ZuuleGateway.jwtController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ZuuleGateway.JwtModel.AuthRequest;
import com.ZuuleGateway.JwtModel.User;
import com.ZuuleGateway.Service.CustomUserdetailsService;
import com.ZuuleGateway.Service.UserService;
import com.ZuuleGateway.Util.JwtUtil;

@RestController
@Component
public class JwtController {
	@Autowired
	private UserService UserService;

	@Autowired
	private AuthenticationManager authenticationmanager;
	
	@Autowired
	private CustomUserdetailsService customuserdetailsservice;
	@Autowired
	private JwtUtil jwtutil;

	@GetMapping("/hello")
	public String khushaamdeed() {
		return "Welcome to Scriptbees !!";
	}

	@PostMapping("/authenticate")
	public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
		try {
			authenticationmanager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
		} catch (Exception ex) {
			throw new Exception("inavalid username/password");
		}
		return jwtutil.generateToken(authRequest.getUserName());
	}

	@GetMapping("/user")
	private List<User> getAllUsers() {
		return UserService.getAllUsers();
	}

	@PostMapping("/create")
	private int saveUser(@RequestBody User user) {
		UserService.saveOrUpdate(user);
		return user.getId();
	}
}
