package com.wpl.bidding.dao;

import java.util.List;

import javax.sql.DataSource;

import com.wpl.bidding.model.UserCategories;

public interface UserDao {
	
	public abstract void setDataSource(DataSource dataSource);

	public List<UserCategories> getUserCategories(int userId);

	public List<UserCategories> updateUserCategories(int userId,int categoryId,int categoryLimit);

	public List<UserCategories> addCategory(int userId, String categoryName,int categoryLimit);

}
