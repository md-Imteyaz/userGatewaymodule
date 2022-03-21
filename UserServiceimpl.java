package com.ZuuleGatewayserviceImpl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.ZuuleGateway.JwtModel.User;

public class UserServiceimpl implements UserDetails {
	@Autowired
	private User jwtusererquest;

	public UserServiceimpl(User jwtusererquest) {
		this.jwtusererquest = jwtusererquest;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getPassword() {
		return jwtusererquest.getPassword();
	} 

	@Override
	public String getUsername() {
		return jwtusererquest.getUserName();
	}

}
