package pw.io.booker.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

import pw.io.booker.exception.InvalidAuthException;
import pw.io.booker.model.Authentication;

@Aspect
@Service
public class AuthenticationAspect {
	
	private AuthenticationService authenticationService;
	
	public AuthenticationAspect(AuthenticationService authenticationService) {
		super();
		this.authenticationService = authenticationService;
	}



//	@Around("execution(* pw.io.booker.controller..*(..)) && args(token,..)")
//	public Object requestAccess(ProceedingJoinPoint proceedingJoinPoint, String token) throws Throwable
//	{
//		Authentication authentication;
//		if(token == null || "".equals(token)) // is null or blank
//		{
//			throw new InvalidAuthException("Token is blank");
//		}
//		authentication = authenticationService.findByToken(token);
//		if(authentication == null)
//		{
//			throw new InvalidAuthException("Invalid Token");
//		}
//		return proceedingJoinPoint.proceed();
//	}
	
}
