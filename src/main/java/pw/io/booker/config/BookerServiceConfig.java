package pw.io.booker.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import pw.io.booker.repo.AuthenticationRepository;
import pw.io.booker.repo.CustomerRepository;
import pw.io.booker.service.AuthenticationService;

@Configuration
public class BookerServiceConfig {

	@Bean
	public AuthenticationService authenticationService(CustomerRepository customerRepository,
			AuthenticationRepository authenticationRepository)
	{
		return new AuthenticationService(customerRepository, authenticationRepository);
	}
	
}
