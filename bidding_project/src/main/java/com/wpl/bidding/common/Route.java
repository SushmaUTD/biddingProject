/**
 * 
 */
package com.wpl.bidding.common;

/**
 * @author Sushma
 *
 */
public class Route {
	
	//URL's for Micro Services
	public static String basePath = "http://localhost:8080/bidding/";
	public static String loginUrl = "/login?";
	public static String registerUrl = "/register?";
	public static String getProfileInfoUrl = "/getProfileInfo?";
	public static String editProfileInfoUrl = "/editProfile?";
	
	public static final String baseRoute = "/";
	public static final String loginPage = "/login";
	public static final String registerPage = "/register";
	public static final String getUserInfo = "/getProfileInfo";
	public static final String editUserInfo = "/editProfileInfo";
	public static final String postItem = "/postItem";
	public static final String bidForItem = "/bidForItem";
	public static final String postedItems = "/postedItemsList";
	public static final String deletePost = "/deletePost";
	public static final String mybiddedItems = "/getBiddedItems";
	public static final String searchItems = "/searchItems";
	
}
