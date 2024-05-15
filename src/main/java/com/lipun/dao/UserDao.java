package com.lipun.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import com.lipun.dto.User;

public class UserDao {

	public boolean saveUser(User user) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("karthik");
		
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		
		User find = em.find(User.class, user.getEmail());
		
		if (find != null) {
			return false;
		} 
		
		et.begin();
		em.persist(user);
		et.commit();
		
		return true;
		
		
	}

	public User fetchUser(String email, String password) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("karthik");
		
		EntityManager em = emf.createEntityManager();
		
		User user = em.find(User.class, email);
		
		if (user != null) {
			if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
				return user;
			} else {
				return null;
			}
		} 
		return null;
	}
}
