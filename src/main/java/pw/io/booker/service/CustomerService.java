package pw.io.booker.service;

import java.util.List;

import pw.io.booker.model.Customer;
import pw.io.booker.repo.CustomerRepository;

public class CustomerService {

	private CustomerRepository customerRepository;

	public CustomerService(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}
	
	public List<Customer> findAll()
	{
		return (List<Customer>)customerRepository.findAll();
	}
	
	public Customer findById(int id)
	{
		return customerRepository.findById(id).get();
	}
}
