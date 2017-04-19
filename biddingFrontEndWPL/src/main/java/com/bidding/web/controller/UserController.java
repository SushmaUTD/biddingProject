/**
 * 
 */
package com.bidding.web.controller;

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
			return "login-error";
		}
		try {	
			RestTemplate restTemplate = new RestTemplate();
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(Route.basePath+Route.getProfileInfoUrl);
		    customer = restTemplate.getForObject(builder.build().encode().toUri(), UserModel.class);
		    if(customer.getResponse().getResponseCode().equalsIgnoreCase(ConstantMessages.successCode))
		    	{
		   			model.addAttribute("name", customer.getUserDetails().getFirstName()+" "+customer.getUserDetails().getLastName());
		   			return "homePage";
		    	}
		    else
		    	{
		    		model.addAttribute("errorMessage", customer.getResponse().getResponseMessage());
		    		return "login-error";
		    	}
	} catch (Exception e) {
		e.printStackTrace();
	}
		return "login-error";
	}

}
