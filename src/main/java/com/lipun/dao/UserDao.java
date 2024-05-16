package com.lipun.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.lipun.dto.User;

public class UserDao {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("karthik");
	
	EntityManager em = emf.createEntityManager();
	
	EntityTransaction et = em.getTransaction();

	public void saveUser(User user) {
		
		et.begin();
		em.merge(user);
		et.commit();
		
		
	}

	public User fetchUserByEmailAndPassword(String email, String password) {
		
		Query query = em.createQuery("select u from User u where u.email=?1 and u.password=?2");
		query.setParameter(1, email);
		query.setParameter(2, password);
		
		List<User> list = query.getResultList();
		User user = null;
		
		for (User u : list) {
			user = u;
		}
		
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
