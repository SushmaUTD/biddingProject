/**
 * 
 */
package com.wpl.bidding.dao;

import java.util.List;

import javax.sql.DataSource;

import com.wpl.bidding.model.Category;


/**
 * @author Sushma
 *
 */
public interface CategoryDao {
	

	public abstract void setDataSource(DataSource dataSource);

	public List<Category> getUserCategories();

}
