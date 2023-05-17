
package com.cgi.factory;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.cgi.model.Customer;

public class MyFactory {

	private static SessionFactory sessionFactory = null;

	public static SessionFactory getSessionFactory() {
		sessionFactory = new Configuration().configure().addAnnotatedClass(Customer.class).buildSessionFactory();
		return sessionFactory;
	}
}
