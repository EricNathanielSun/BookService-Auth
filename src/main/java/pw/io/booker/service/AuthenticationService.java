package pw.io.booker.service;

import java.util.List;

import javax.transaction.Transactional;

import pw.io.booker.model.Authentication;
import pw.io.booker.model.Customer;
import pw.io.booker.repo.AuthenticationRepository;
import pw.io.booker.repo.CustomerRepository;

@Transactional
public class AuthenticationService {

	private CustomerRepository customerRepository; // in case
	private AuthenticationRepository authenticationRepository;
	
	public AuthenticationService(CustomerRepository customerRepository,
			AuthenticationRepository authenticationRepository) {
		super();
		this.customerRepository = customerRepository;
		this.authenticationRepository = authenticationRepository;
	}

	public List<Authentication> findByCustomer(Customer customer)
	{
		return authenticationRepository.findByCustomer(customer);
	}
	
	public Authentication findByToken(String token)
	{
		return authenticationRepository.findByToken(token);
	}
	
	public Authentication save(Authentication authentication)
	{
		authentication.getCustomer().setAuthentication(authentication);
		customerRepository.save(authentication.getCustomer());
		return authenticationRepository.save(authentication);
	}
	
	public void deleteByCustomer(Customer customer)
	{
		authenticationRepository.deleteAll(findByCustomer(customer));
	}
	
	public void deleteByToken(String token)
	{
		authenticationRepository.delete(findByToken(token));
	}
	
	public Authentication formulateAuthentication(Customer customer)
	{
		
		if(findByCustomer(customer) != null)
		{
			deleteByCustomer(customer);
		}
		
		Authentication authentication = new Authentication();
		authentication.setCustomer(customer);
		authentication.setToken(new TokenCreator().encode(customer));
		return save(authentication);
	}
}
