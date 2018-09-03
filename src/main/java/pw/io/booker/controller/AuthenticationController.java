package pw.io.booker.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pw.io.booker.exception.InvalidUsernameOrPasswordException;
import pw.io.booker.model.Authentication;
import pw.io.booker.model.Customer;
import pw.io.booker.service.AuthenticationService;
import pw.io.booker.service.CustomerService;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
	
	private AuthenticationService authenticationService;
	private CustomerService customerService;

	public AuthenticationController(AuthenticationService authenticationService, CustomerService customerService) {
		super();
		this.authenticationService = authenticationService;
		this.customerService = customerService;
	}

	@PostMapping("/login")
	public String login(@RequestBody Customer customer) throws InvalidUsernameOrPasswordException
	{
		// To compare with input
		Customer actualCustomer = customerService.findByUsername(customer.getUsername());
		if(!actualCustomer.getPassword().equals(customer.getPassword()))
		{
			throw new InvalidUsernameOrPasswordException();
		}
		Authentication authentication = authenticationService.formulateAuthentication(actualCustomer);
		return authentication.getToken();
	}
	
	@DeleteMapping("/logout")
	public void logout(@RequestHeader("token") String token)
	{
		authenticationService.deleteByToken(token);
	}
}
