/**
 * 
 */
package com.wpl.bidding.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wpl.bidding.common.ConstantMessages;
import com.wpl.bidding.common.Route;
import com.wpl.bidding.model.Response;
import com.wpl.bidding.model.UserModel;
import com.wpl.bidding.persist.User;
import com.wpl.bidding.service.UserService;

/**
 * @author Sushma
 *
 */
@Controller
public class UserController {
	
	@Autowired UserService userService;
	
	@RequestMapping(value = Route.getUserInfo, method = RequestMethod.GET,produces="application/json")	
	public @ResponseBody UserModel getUserInfo(@RequestParam(value = "userId") int userId) {
		UserModel userModel = new UserModel();
		User user = new User();
		if (userId == 0)
		{
			userModel.setResponse(new Response(ConstantMessages.MandatoryParamsMissing, ConstantMessages.mandatoryParameterMissingCode));
			userModel.setUserDetails(user);
			return userModel;
		}
		else {
			user = userService.getUserInfo(userId);
			if (user == null)
			{
				userModel.setResponse(new Response(ConstantMessages.noUser,ConstantMessages.emptyResponseCode));
			}
			else
			{
				userModel.setResponse(new Response(ConstantMessages.foundUser,ConstantMessages.successCode));	
			}
		userModel.setUserDetails(user);	
		}
		return userModel;
	}
	
	@RequestMapping(value = Route.editUserInfo, method = RequestMethod.POST,produces="application/json")	
	public @ResponseBody Response getUserInfo(@RequestBody User userInfo) {
		Response response = new Response();
		int result;
		if (userInfo.getUserId() == 0)
		{
			response.setResponseCode(ConstantMessages.mandatoryParameterMissingCode);
			response.setResponseMessage(ConstantMessages.MandatoryParamsMissing);
			return response;
		}
		else {
			result = userService.updateUserInfo(userInfo);
			if (result == 0)
			{
				response.setResponseCode(ConstantMessages.emptyResponseCode);
				response.setResponseMessage(ConstantMessages.noUser);
			}
			else
			{
				response.setResponseCode(ConstantMessages.successCode);
				response.setResponseMessage(ConstantMessages.updatedUserInfo);
			}
		}
		return response;
	}
	

}
