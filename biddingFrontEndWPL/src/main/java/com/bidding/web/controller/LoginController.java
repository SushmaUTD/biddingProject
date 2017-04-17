package com.bidding.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
//import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.bidding.web.common.ConstantMessages;
import com.bidding.web.common.Route;
import com.bidding.web.model.UserModel;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class LoginController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		return "hello";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String hello(@RequestParam("userName") String userName, @RequestParam("password") String password,HttpServletRequest request,ModelMap model) {

		UserModel customer = new UserModel();
		//ClientResponse response;
		try {
			  	RestTemplate restTemplate = new RestTemplate();
			    UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(Route.basePath+Route.loginUrl)
			            .queryParam("username", userName)
			            .queryParam("password", password);
			    //ResponseEntity<String> result = restTemplate.exchange( builder.build().encode().toUri(),HttpMethod.GET, entity, String.class);
			    customer = restTemplate.getForObject(builder.build().encode().toUri(), UserModel.class);

		if(customer.getResponse().getResponseCode().equalsIgnoreCase(ConstantMessages.successCode))
		{
			HttpSession session = request.getSession();
			session.setAttribute("user", customer.getUserDetails().getUserName());
			model.addAttribute("name", customer.getUserDetails().getFirstName()+" "+customer.getUserDetails().getLastName());
			return "welcome-page";
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