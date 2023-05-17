package com.cgi.service;

import java.util.List;

import com.cgi.model.Customer;

public interface CustomerService {

	public Customer createCustomer(Customer customer);
	public List<Customer> getAllCustomers();
	public void deleteCustomerById(int customerId);
	public void deleteAllCustomers();
	public Customer getCustomerById(int customerId);
	public Customer updateCustomer(int customerId, Customer customer);

}
