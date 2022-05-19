package com.advancejava.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.advancejava.entity.User;

@Component
public class UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	
	//Sanjeev Project
	//Commit Second
	public User validateUser(String username, String password) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();

		Query query = session.createQuery("From User WHERE username =:username AND password =:password");
		query.setParameter("username", username);
		query.setParameter("password", password);

		List<User> list = query.list();
		if (list.size() > 0) {
			return list.get(0);
		}
		else {
			return new User();
		}
	}
}
