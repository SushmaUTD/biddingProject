/**
 * 
 */
package com.wpl.bidding.service;

import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.wpl.bidding.common.Route;
import com.wpl.bidding.model.Response;
import com.wpl.bidding.model.UserModel;
import com.wpl.bidding.persist.User;

/**
 * @author Sushma
 *
 */
public class UserServiceImpl implements UserService{
	
	public UserModel getUserInfo(int userId) {
		UserModel customer = new UserModel();
		RestTemplate restTemplate = new RestTemplate();
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(Route.basePath+Route.getProfileInfoUrl);
	    customer = restTemplate.getForObject(builder.build().encode().toUri(), UserModel.class);
	    return customer;
	}
	
	public Response updateUserInfo(User userInfo) {
		Response response = new Response();
		RestTemplate restTemplate = new RestTemplate();
	    response = restTemplate.postForObject(Route.basePath+Route.editProfileInfoUrl,userInfo,Response.class);
		return response;
	}
}
