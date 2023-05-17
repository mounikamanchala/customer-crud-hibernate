package com.cgi.service;

import java.util.List;

import com.cgi.dao.CustomerDao;
import com.cgi.dao.CustomerDaoImp;
import com.cgi.model.Customer;

public class CustomerServiceImpl implements CustomerService {

	private CustomerDao customerDao;
	{
		customerDao = new CustomerDaoImp();
	}

	@Override
	public Customer createCustomer(Customer customer) {

		return customerDao.createCustomer(customer);
	}

	@Override
	public List<Customer> getAllCustomers() {

		return customerDao.getAllCustomers();
	}

	@Override
	public void deleteCustomerById(int customerId) {
		customerDao.deleteCustomerById(customerId);
	}

	@Override
	public void deleteAllCustomers() {
		customerDao.deleteAllCustomers();
	}

	@Override
	public Customer getCustomerById(int customerId) {
		return customerDao.getCustomerById(customerId);
	}

	@Override
	public Customer updateCustomer(int customerId, Customer customer) {
		return customerDao.updateCustomer(customerId, customer);
	}

}
