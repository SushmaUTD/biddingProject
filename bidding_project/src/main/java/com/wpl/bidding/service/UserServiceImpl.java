/**
 * 
 */
package com.wpl.bidding.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wpl.bidding.dao.UserDaoImpl;
import com.wpl.bidding.model.UserCategories;

/**
 * @author Sushma
 *
 */
public class UserServiceImpl implements UserService{

	@Autowired UserDaoImpl userDao;
	
	@Override
	public List<UserCategories> getUserCategories(int userId) {
		List<UserCategories> userCategories=userDao.getUserCategories(userId);
		return userCategories;
	}

	@Override
	public List<UserCategories> updateUserCategories() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserCategories> addCategory(int userId,String categoryName, int categoryLimit) {
		return userDao.addCategory(userId, categoryName, categoryLimit);
	}

}
