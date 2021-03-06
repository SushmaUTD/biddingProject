package com.bidding.web.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.bidding.web.common.ConstantMessages;
import com.bidding.web.common.Route;
import com.bidding.web.model.Login;
import com.bidding.web.model.User;
import com.bidding.web.model.UserModel;
import com.bidding.web.model.createBid;
import com.bidding.web.utils.GeoLocationUtils;
import java.util.*;
@Controller
public class LoginController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String landingPage(ModelMap model) {
		return "landingPage";
	}
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String erre(ModelMap model) {
		List<createBid> itemsList = new ArrayList<createBid>(); 
		createBid item = new createBid();
		item.setProductName("pen");
		item.setProductDescription("black");
		item.setImageUrl("https://www.google.com/search?q=pen&source=lnms&tbm=isch&sa=X&ved=0ahUKEwjQ-oaXq7zTAhUpwYMKHU6jA3QQ_AUICCgB&biw=1334&bih=560#imgrc=_");
		item.setPrice(10);
		itemsList.add(item);
		createBid item1 = new createBid();
		item1.setProductName("pencil");
		item1.setProductDescription("blue");
		item1.setImageUrl("https://www.google.com/search?q=pen&source=lnms&tbm=isch&sa=X&ved=0ahUKEwjQ-oaXq7zTAhUpwYMKHU6jA3QQ_AUICCgB&biw=1334&bih=560#imgrc=_");
		item1.setPrice(5);
		itemsList.add(item1);
		model.addAttribute("itemsList",itemsList);
		return "createNewBid";
	}
	
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpServletRequest request,ModelMap model) throws IOException {
		UserModel customer = new UserModel();
		Login userDetails = new Login();
		userDetails.setUsername(request.getParameter("userName"));
		userDetails.setPassword(request.getParameter("password"));
		userDetails.setLocation(GeoLocationUtils.getLocation("33.0006239", "-96.7771018"));
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
			session.setAttribute("user", customer.getUserDetails());
			model.addAttribute("errorMessage", customer.getUserDetails().getFirstName()+" "+customer.getUserDetails().getLastName());
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
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(HttpServletRequest request,ModelMap model) {
		UserModel customer = new UserModel();
		//Get values from the form for registering a new user
		User userDetails = new User();
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
		
		//check for mandatory parameters
		if(userDetails.getUserName() == null || userDetails.getPassword() == null || userDetails.getUserName().isEmpty()
				|| userDetails.getPassword().isEmpty() || userDetails.getFirstName().isEmpty() || userDetails.getFirstName() == null || userDetails.getEmail() == null || userDetails.getEmail().isEmpty() ||
						userDetails.getMobile().isEmpty() || userDetails.getMobile() == null || userDetails.getLocation() == null || userDetails.getLocation().isEmpty())
		{
			model.addAttribute("errorMessage", ConstantMessages.wrongUserNameOrPassword);
			return "register-error";
		}
		try {	
			RestTemplate restTemplate = new RestTemplate();
			customer = restTemplate.postForObject(Route.basePath+Route.registerUrl,userDetails, UserModel.class);
		if(customer.getResponse().getResponseCode().equalsIgnoreCase(ConstantMessages.successCode))
		{
			HttpSession session = request.getSession();
			session.setAttribute("user", customer.getUserDetails());
			model.addAttribute("name", customer.getUserDetails().getFirstName()+" "+customer.getUserDetails().getLastName());
			return "landingPage";
		}
		else
		{
			model.addAttribute("errorMessage", customer.getResponse().getResponseMessage());
			return "register-error";
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
		return "register-error";
	}
}
