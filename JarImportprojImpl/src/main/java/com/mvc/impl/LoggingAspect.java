package com.mvc.impl;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	private static final Logger LOGGER= org.slf4j.LoggerFactory.getLogger(LoggingAspect.class);
	@Before("execution(public * com.mvc.impl.AlienRESTController.getAliens())")
	public void logBefore() {
		//System.out.println("getAlien method excecuted through Aspect");
		LOGGER.info("getAlien method called through Aspect");
	}
	
	@After("execution(public * com.mvc.impl.AlienRESTController.getAliens())")
	public void logAfter() {
		//System.out.println("getAlien method excecuted through Aspect");
		LOGGER.info("getAlien method executed through Aspect");
	}
	
	@AfterReturning("execution(public * com.mvc.impl.AlienRESTController.getAliens())")
	public void logAfterReturning() {
		//System.out.println("getAlien method excecuted through Aspect");
		LOGGER.info("getAlien method executed through Aspect");
	}
	
	@AfterThrowing("execution(public * com.mvc.impl.AlienRESTController.getAliens())")
	public void logException() {
		//System.out.println("getAlien method excecuted through Aspect");
		LOGGER.info("Issue");
	}
}
