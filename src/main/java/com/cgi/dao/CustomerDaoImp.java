package com.cgi.dao;

import java.util.List;
import java.util.Random;

import javax.persistence.Query;

import org.hibernate.Session;

import com.cgi.factory.MyFactory;
import com.cgi.model.Customer;

public class CustomerDaoImp implements CustomerDao {

	private Session session;

	{
		session = MyFactory.getSessionFactory().openSession();
	}

	@Override
	public Customer createCustomer(Customer customer) {
		session.getTransaction().begin();
		customer.setCustomerId(new Random().nextInt());
		session.save(customer);
		session.getTransaction().commit();
		return customer;
	}

	@Override
	public List<Customer> getAllCustomers() {
		Query query = session.createQuery("FROM Customer");
		List<Customer> customerList = query.getResultList();
		for (Customer s : customerList) {
			System.out.println(s);

		}
		return customerList;
	}

	@Override
	public void deleteCustomerById(int customerId) {
		session.getTransaction().begin();
		Customer s = session.get(Customer.class, customerId);

		if (s == null) {
			System.out.println("no such id found: " + customerId);
		} else {
			session.delete(s);

			System.out.println("one item deleted...");
		}
		session.getTransaction().commit();
	}

	@Override
	public void deleteAllCustomers() {
		session.getTransaction().begin();

		Query query = session.createQuery("FROM Customer", Customer.class);
		List<Customer> list = query.getResultList();
		for (Customer s : list) {
			session.delete(s);
		}
		session.getTransaction().commit();
	}

	@Override
	public Customer getCustomerById(int customerId) {
		session.getTransaction().begin();
		Customer s = session.find(Customer.class, customerId);

		if (s == null) {
			System.out.println("no such id..");
		} else {
			System.out.println("Found: " + s);
		}
		return s;

	}

	@Override
	public Customer updateCustomer(int customerId, Customer customer) {
		session.getTransaction().begin();
		Customer s = session.get(Customer.class, customerId);

		if (s == null) {
			System.out.println("no such id found: " + customerId);
		} else {

			s.setFirstName(customer.getFirstName());
			s.setLastName(customer.getLastName());
			s.setEmail(customer.getEmail());
			session.merge(s);

			System.out.println("one item updated...");
		}
		session.getTransaction().commit();
		return s;
		
		

	}

}
