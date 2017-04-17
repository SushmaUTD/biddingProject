package com.bidding.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
//import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.RestTemplate;

import com.bidding.web.common.ConstantMessages;
import com.bidding.web.common.Route;
import com.bidding.web.model.Login;
import com.bidding.web.model.UserModel;

@Controller
public class LoginController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String landingPage(ModelMap model) {
		return "landingPage";
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleResourceNotFoundException() {
        return "error404";
    }

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpServletRequest request,ModelMap model) {

		UserModel customer = new UserModel();
		Login userDetails = new Login();
		userDetails.setUsername(request.getParameter("userName"));
		userDetails.setPassword(request.getParameter("password"));
		
		if(userDetails.getUsername() == null || userDetails.getPassword() == null)
		{
			model.addAttribute("errorMessage", ConstantMessages.wrongUserNameOrPassword);
			return "login-error";
		}
		try {
			
			  	RestTemplate restTemplate = new RestTemplate();
			    customer = restTemplate.postForObject(Route.basePath+Route.loginUrl,userDetails, UserModel.class);

		if(customer.getResponse().getResponseCode().equalsIgnoreCase(ConstantMessages.successCode))
		{
			HttpSession session = request.getSession();
			session.setAttribute("user", customer.getUserDetails().getUserName());
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