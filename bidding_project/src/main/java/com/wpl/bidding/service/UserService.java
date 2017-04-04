/**
 * 
 */
package com.wpl.bidding.service;

import java.util.List;

import com.wpl.bidding.model.UserCategories;

/**
 * @author Sushma
 *
 */
public interface UserService {
	
	public List<UserCategories> getUserCategories(int userId);
	
	public List<UserCategories> updateUserCategories();
	
	public List<UserCategories> addCategory(int userId,String categoryName, int categoryLimit);

}
