/**
 * 
 */
package com.wpl.bidding.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.wpl.bidding.dao.UserDaoImpl;
import com.wpl.bidding.persist.User;

/**
 * @author Sushma
 *
 */
public class UserServiceImpl implements UserService{

	@Autowired UserDaoImpl userDao;

	public User getUserInfo(int userId) {
		// TODO Auto-generated method stub
		return userDao.getUserInfo(userId);
	}
	
	public int updateUserInfo(User userInfo) {
		// TODO Auto-generated method stub
		return userDao.updateUserInfo(userInfo);
	}
	
	

}
