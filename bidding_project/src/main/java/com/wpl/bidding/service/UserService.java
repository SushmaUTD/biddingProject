/**
 * 
 */
package com.wpl.bidding.service;

import com.wpl.bidding.model.Response;
import com.wpl.bidding.model.UserModel;
import com.wpl.bidding.persist.User;

/**
 * @author Sushma
 *
 */
public interface UserService {
	
	public UserModel getUserInfo(int userId);
	public Response updateUserInfo(User userInfo);
}
