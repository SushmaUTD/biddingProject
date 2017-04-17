package com.wpl.bidding.dao;

import com.wpl.bidding.persist.User;

public interface LoginDao {
	public User login(String userName,String password);
	public User register(User user);
}
