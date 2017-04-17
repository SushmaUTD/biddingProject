/**
 * 
 */
package com.wpl.bidding.service;

import com.wpl.bidding.persist.User;

/**
 * @author Sushma
 *
 */
public interface UserService {
	
	public User getUserInfo(int userId);
	public int updateUserInfo(User userInfo);
}
