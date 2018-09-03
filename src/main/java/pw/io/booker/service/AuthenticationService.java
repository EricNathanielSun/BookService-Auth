package pw.io.booker.service;

import pw.io.booker.model.Authentication;
import pw.io.booker.model.Customer;
import pw.io.booker.repo.AuthenticationRepository;
import pw.io.booker.repo.CustomerRepository;

public class AuthenticationService {

	private CustomerRepository customerRepository; // in case
	private AuthenticationRepository authenticationRepository;
	
	public AuthenticationService(CustomerRepository customerRepository,
			AuthenticationRepository authenticationRepository) {
		super();
		this.customerRepository = customerRepository;
		this.authenticationRepository = authenticationRepository;
	}

	public Authentication findByCustomer(Customer customer)
	{
		return authenticationRepository.findByCustomer(customer);
	}
	
	public Authentication findByToken(String token)
	{
		return authenticationRepository.findByToken(token);
	}
	
}
