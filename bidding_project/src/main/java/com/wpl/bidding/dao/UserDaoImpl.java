package com.wpl.bidding.dao;

import java.util.Date;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.wpl.bidding.persist.User;


public class UserDaoImpl implements UserDao {
	@Autowired
	SessionFactory sessionFactory;

	protected Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public User getUserInfo(int userId)
	{
		User results = new User();
		try{
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from User where userId="+userId);
		results = (User) query.list().get(0);
		session.getTransaction().commit();
		}catch(Exception e)
		{
			System.out.print("Error while getting user"+e);
			results = null;
		}
		return results;
	}

	public int updateUserInfo(User userInfo) {
		try{
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			userInfo.setModifiedDate(new Date(System.currentTimeMillis()));
			session.update(userInfo);
			session.getTransaction().commit();
			}catch(Exception e)
			{
				System.out.println("Error while creating user"+e);
				return 0;
			}
			return 1;
	}
	
	
}
