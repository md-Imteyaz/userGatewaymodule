package com.ZuuleGateway.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ZuuleGateway.JwtModel.User;


public interface UserRepo extends JpaRepository<User, String> {
	List<User> getallUser = null;

	User findByUserName(String userName);

}
