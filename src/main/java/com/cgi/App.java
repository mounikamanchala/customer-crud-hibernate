package com.cgi;

import java.util.Random;
import java.util.Scanner;

import com.cgi.model.Customer;
import com.cgi.service.CustomerService;
import com.cgi.service.CustomerServiceImpl;

/**
 * Hello world!
 *
 */
public class App {
	private static CustomerService customerService = new CustomerServiceImpl();
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int choice = 0;
		do {
			System.out.println("1. get all customers");
			System.out.println("2. create customer");
			System.out.println("3. delete by customer id");
			System.out.println("4. delete all customer");
			System.out.println("5. get customer by customer id");
			System.out.println("6. update customer by id");
			System.out.println("enter your choice");
			choice = scanner.nextInt();
			switch (choice) {
			case 1:
				customerService.getAllCustomers();
				break;
			case 2:
				Customer input = new Customer();
				System.out.println("Enter FirstName :");
				input.setFirstName(scanner.next());
				System.out.println("enter lastname");
				input.setLastName(scanner.next());
				System.out.println("enter email");
				input.setEmail(scanner.next());
				Customer c = customerService
						.createCustomer(input);
				System.out.println(c);
				break;
			case 3:
				System.out.println("enter customer id to delete");
				int cId = scanner.nextInt();
				customerService.deleteCustomerById(cId);
				break;
			case 4:
				customerService.deleteAllCustomers();
				break;
			case 5:
				System.out.println("enter customer id to get the details");
				int cId1 = scanner.nextInt();
				customerService.getCustomerById(cId1);
				break;
			case 6:
				System.out.println("update customer details by cId");
				int cId2 = scanner.nextInt();
				Customer cus = new Customer();
				cus.setCustomerId(cId2);
				System.out.println("Enter FirstName :");
				cus.setFirstName(scanner.next());
				System.out.println("enter lastname");
				cus.setLastName(scanner.next());
				System.out.println("enter email");
				cus.setEmail(scanner.next());
				customerService.updateCustomer(cId2, cus);
			}
		} while (choice != 0);
	}
}
