package com.wpl.bidding.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.wpl.bidding.model.Category;

public class CategoryDaoImpl implements CategoryDao {

	public JdbcTemplate jdbcTemplate;
	
	@Override
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Category> getUserCategories() {
		// TODO Auto-generated method stub
		return null;
	}

}
