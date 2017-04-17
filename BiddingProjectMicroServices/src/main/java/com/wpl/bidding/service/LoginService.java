package com.wpl.bidding.service;

import com.wpl.bidding.persist.User;

public interface LoginService {

	public User login(String username, String password);
	public User register(User user);
	
}
