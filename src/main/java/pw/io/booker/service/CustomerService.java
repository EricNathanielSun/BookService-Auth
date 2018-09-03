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
	
	public Customer findByUsername(String userName)
	{
		return customerRepository.findByUsername(userName);
	}
	
	public Customer save(Customer customer)
	{
		return customerRepository.save(customer);
	}
	
	public List<Customer> saveAll(List<Customer> customers)
	{
		return (List<Customer>) customerRepository.saveAll(customers);
	}
	
	public void delete(Customer customer)
	{
		customerRepository.delete(customer);
	}
	
	public void deleteAll(List<Customer> customers)
	{
		customerRepository.deleteAll(customers);
	}
}
