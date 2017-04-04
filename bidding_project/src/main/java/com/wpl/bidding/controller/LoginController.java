package com.wpl.bidding.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
import com.wpl.bidding.service.LoginServiceImpl;

@Controller
public class LoginController {

	@Autowired
	LoginServiceImpl loginService;
	
	@RequestMapping(value = Route.registerPage, method = RequestMethod.POST,produces="application/json")	
	public @ResponseBody UserModel register(@RequestBody User user) {
		UserModel userModel = new UserModel();
		User newUser = new User();
		if (user.getUserName() == null || user.getPassword() == null || user.getUserName().isEmpty()
				|| user.getPassword().isEmpty() || user.getFirstName().isEmpty() || user.getFirstName() == null || user.getEmail() == null || user.getEmail().isEmpty() ||
				user.getMobile().isEmpty() || user.getMobile() == null || user.getLocation() == null || user.getLocation().isEmpty() )
		{
			userModel.setResponse(new Response(ConstantMessages.MandatoryParamsMissing, ConstantMessages.mandatoryParameterMissingCode));
			userModel.setUserDetails(newUser);
			return userModel;
		}
		else {
			user = loginService.register(user);
			if (user == null)
			{
				userModel.setResponse(new Response(ConstantMessages.registerFailureMessage,ConstantMessages.emptyResponseCode));
			}
			else
			{
				userModel.setResponse(new Response(ConstantMessages.creationMessage,ConstantMessages.creationCode));	
			}
		userModel.setUserDetails(user);	
		}
		return userModel;
	}

	@RequestMapping(value = Route.loginPage, method = RequestMethod.GET,produces="application/json")	
	public @ResponseBody UserModel homePage(@RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password, ModelMap model) {
		UserModel userModel = new UserModel();
		User user = new User();
		if (username == null || password == null || username.isEmpty()
				|| password.isEmpty())
		{
			userModel.setResponse(new Response(ConstantMessages.MandatoryParamsMissing, ConstantMessages.mandatoryParameterMissingCode));
			userModel.setUserDetails(user);
			return userModel;
		}
		else {
			user = loginService.login(username, password);
			if (user == null)
			{
				userModel.setResponse(new Response(ConstantMessages.loginFailureMessage,ConstantMessages.emptyResponseCode));
			}
			else
			{
				userModel.setResponse(new Response(ConstantMessages.loginSuccessMessage,ConstantMessages.successCode));	
			}
		userModel.setUserDetails(user);	
		}
		return userModel;
	}
}
