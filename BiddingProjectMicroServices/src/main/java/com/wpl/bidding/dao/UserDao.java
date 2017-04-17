package com.wpl.bidding.dao;

import com.wpl.bidding.persist.User;


public interface UserDao {
	
	public User getUserInfo(int userId);
	public int updateUserInfo(User userInfo);
}
