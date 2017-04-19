/**
 * 
 */
package com.bidding.web.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.bidding.web.common.ConstantMessages;
import com.bidding.web.common.Route;
import com.bidding.web.model.Response;
import com.bidding.web.model.User;
import com.bidding.web.model.UserModel;

/**
 * @author Sushma
 *
 */
public class UserController {
	
	@RequestMapping(value = "/getUserProfile", method = RequestMethod.GET)
	public String login(@RequestParam("userId") int userId ,HttpServletRequest request,ModelMap model) {
		UserModel customer = new UserModel();
		if(userId==0)
		{
			model.addAttribute("errorMessage", ConstantMessages.serverError);
			return "error";
		}
		try {	
			RestTemplate restTemplate = new RestTemplate();
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(Route.basePath+Route.getProfileInfoUrl);
			builder.queryParam("userId", userId);
		    customer = restTemplate.getForObject(builder.build().encode().toUri(), UserModel.class);
		    if(customer.getResponse().getResponseCode().equalsIgnoreCase(ConstantMessages.successCode))
		    	{
		   			model.addAttribute("userBean", customer.getUserDetails());
		   			return "profilePage";
		    	}
		    else
		    	{
		    		model.addAttribute("errorMessage", customer.getResponse().getResponseMessage());
		    		return "error";
		    	}
	} catch (Exception e) {
		e.printStackTrace();
	}
		return "error";
	}
	
	
	@RequestMapping(value = "/editUserProfile", method = RequestMethod.GET)
	public String login(HttpServletRequest request,ModelMap model) {
		UserModel customer = new UserModel();
		//Get values from the form for registering a new user
		User userDetails = new User();
		userDetails.setUserId(Integer.parseInt(request.getParameter("userId")));
		userDetails.setUserName(request.getParameter("userName"));
		userDetails.setPassword(request.getParameter("password"));
		userDetails.setCity(request.getParameter("city"));
		userDetails.setCountry(request.getParameter("country"));
		userDetails.setDOB(new Date(request.getParameter("dob")));
		userDetails.setEmail(request.getParameter("email"));
		userDetails.setFirstName(request.getParameter("firstName"));
		userDetails.setLastName(request.getParameter("lastName"));
		userDetails.setLocation(request.getParameter("location"));
		userDetails.setMobile(request.getParameter("mobile"));
		userDetails.setSex(request.getParameter("sex"));
		userDetails.setState(request.getParameter("state"));
		userDetails.setStreetName(request.getParameter("streetName"));
		userDetails.setZipcode(request.getParameter("zipcode"));
		if(userDetails.getUserId()==0)
		{
			model.addAttribute("errorMessage", ConstantMessages.serverError);
			return "error";
		}
		try {	
			RestTemplate restTemplate = new RestTemplate();
		    customer = restTemplate.postForObject(Route.basePath+Route.editProfileInfoUrl,userDetails, UserModel.class);
		    if(customer.getResponse().getResponseCode().equalsIgnoreCase(ConstantMessages.successCode))
		    	{
		   			model.addAttribute("message", customer.getResponse().getResponseMessage());
		   			model.addObject("userBean",customer.getUserDetails());
		   			return "profilePage";
		    	}
		    else
		    	{
		    		model.addAttribute("errorMessage", customer.getResponse().getResponseMessage());
		    		return "error";
		    	}
	} catch (Exception e) {
		e.printStackTrace();
	}
		return "error";
	}
	
	

}
