package com.example.t5.services;

import org.apache.tapestry5.annotations.Service;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.springframework.web.servlet.ViewResolver;

import com.example.mongo.model.Customer;
import com.example.mongo.repo.CustomerRepository;

/**
 * Created by code8 on 12/10/15.
 */
public class SomeInterfaceImpl implements SomeInterface {

	@Inject
	private CustomerRepository repository;

    final ViewResolver springViewResolver;

    public SomeInterfaceImpl(@Service("mvcViewResolver") ViewResolver springViewResolver) {
        this.springViewResolver = springViewResolver;
    }

    @Override
    public ViewResolver testMethod() {
        return springViewResolver;
    }

    @Override    
    public String doSomething() {
		for (Customer customer : repository.findAll()) {
			System.out.println(customer);
		}

		repository.deleteAll();

		// save a couple of customers
		repository.save(new Customer("Alice", "Smith"));
		repository.save(new Customer("Bob", "Smith"));

		// fetch all customers
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (Customer customer : repository.findAll()) {
			System.out.println(customer);
		}
		System.out.println();

		// fetch an individual customer
		System.out.println("Customer found with findByFirstName('Alice'):");
		System.out.println("--------------------------------");
		System.out.println(repository.findByFirstName("Alice"));

		System.out.println("Customers found with findByLastName('Smith'):");
		System.out.println("--------------------------------");
		for (Customer customer : repository.findByLastName("Smith")) {
			System.out.println(customer);
		}
		
		return null;
    	
    }
}
