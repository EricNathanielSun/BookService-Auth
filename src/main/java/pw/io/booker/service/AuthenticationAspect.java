package pw.io.booker.service;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import pw.io.booker.exception.InvalidAuthException;
import pw.io.booker.model.Authentication;

@Aspect
public class AuthenticationAspect {
	
	private AuthenticationService authenticationService;
	private Logger logger;
	
	public AuthenticationAspect(AuthenticationService authenticationService) {
		super();
		this.authenticationService = authenticationService;
		logger = Logger.getLogger(AuthenticationAspect.class);
	}



	@Around("execution(* pw.io.booker.controller..*(..)) && args(token,..)")
	public Object requestAccess(ProceedingJoinPoint proceedingJoinPoint, String token) throws Throwable
	{
		Authentication authentication;
		if(token == null || "".equals(token)) // is null or blank
		{
			logger.debug("Access Request denied: Token is blank");
			throw new InvalidAuthException("Token is blank");
		}
		authentication = authenticationService.findByToken(token);
		if(authentication == null)
		{
			logger.debug("Access Request denied: Token is invalid");
			throw new InvalidAuthException("Invalid Token");
		}
		return proceedingJoinPoint.proceed();
	}
	
	@Before("execution(* pw.io.booker.service..*(..))")
	public void logServiceMethodStart(JoinPoint joinPoint)
	{
		logger.info("Method started: " + joinPoint.getSignature().getName());
	}
	
	@After("execution(* pw.io.booker.service..*(..))")
	public void logServiceMethodEnd(JoinPoint joinPoint)
	{
		logger.info("Method ended: " + joinPoint.getSignature().getName());
	}
}
