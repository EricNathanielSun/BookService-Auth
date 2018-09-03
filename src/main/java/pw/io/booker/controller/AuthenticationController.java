package pw.io.booker.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pw.io.booker.model.Customer;
import pw.io.booker.repo.CustomerRepository;
import pw.io.booker.service.AuthenticationService;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
	
	private AuthenticationService authenticationService;

	@PostMapping("/login")
	public String login(@RequestBody Customer customer)
	{
		
	}
	
}
