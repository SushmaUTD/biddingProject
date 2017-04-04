package com.wpl.bidding.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.wpl.bidding.model.UserCategories;

public class UserDaoImpl implements UserDao {

	public JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<UserCategories> getUserCategories(int userId) {
		String getUserCategories = "select * from userCategory where userId='"
				+ userId + "'";
		List<UserCategories> userDetails = new ArrayList<UserCategories>();
		userDetails = jdbcTemplate.query(getUserCategories,
				new RowMapper<UserCategories>() {
					@Override
					public UserCategories mapRow(ResultSet rs, int rowNum)
							throws SQLException {

						System.out.println("Got Result");
						UserCategories userCategory = new UserCategories();
						userCategory.setUserId(rs.getInt("userId"));
						System.out.print(rs.getInt("userId"));
						userCategory.setCategoryName(rs
								.getString("categoryName"));
						System.out.print(rs.getString("categoryName"));
						userCategory.setCategoryLimit(rs
								.getInt("categoryLimit"));
						System.out.print(rs.getInt("categoryLimit"));
						return userCategory;
					}
				});

		return userDetails;
	}

	@Override
	public List<UserCategories> updateUserCategories(int userId,
			int categoryId, int categoryLimit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserCategories> addCategory(int userId, String categoryName,
			int categoryLimit) {
		  String sql = "INSERT INTO userCategory (userId,categoryName,categoryLimit)"
		  + " VALUES (?, ?, ?)"; 
		  jdbcTemplate.update(sql, userId,categoryName,categoryLimit);	  
		return getUserCategories(userId);
	}

}
