package com.ZuuleGateway.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ZuuleGateway.JwtModel.User;
import com.ZuuleGateway.Repo.UserRepo;
@Service
public class UserService {
	@Autowired
	private UserRepo userRepo;
	
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	public void saveOrUpdate(User user) {
		userRepo.save(user);
		
	}
	

}
