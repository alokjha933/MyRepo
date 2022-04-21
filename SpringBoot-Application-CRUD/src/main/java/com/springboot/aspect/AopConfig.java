package com.springboot.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.springboot.model.Student;

@Aspect
@Component
@EnableAspectJAutoProxy
public class AopConfig {

	private Logger log = LoggerFactory.getLogger(AopConfig.class);

	@Before(value = "execution(* com.springboot.controller.ApplicationController.*(..))")
	public void logStatementBefore(JoinPoint joinPoint) {
		log.info("Executing {}", joinPoint.getSignature().getName());

	}

	@After(value = "execution(* com.springboot.controller.ApplicationController.*(..))")
	public void logStatementAfter(JoinPoint joinPoint) {
		log.info("Executing {}", joinPoint.getSignature().getName());

	}

	// Displays all the available methods i.e. the advice will be called for all the
	// methods
	@Pointcut(value = "execution(* com.springboot.controller.ApplicationController.*(..))")
	private void logDisplayingBalance() {
	}

	@Around(value = "logDisplayingBalance()")
	public void aroundAdvice(ProceedingJoinPoint jp) throws Throwable {
		System.out.println(
				"The method aroundAdvice() before invokation of the method " + jp.getSignature().getName() + " method");
		try {
			jp.proceed();
		} finally {

		}
		System.out.println(
				"The method aroundAdvice() after invokation of the method " + jp.getSignature().getName() + " method");
	}

	@AfterReturning(pointcut = "execution(* com.springboot.controller.ApplicationController.*(..))", returning = "value")
	public void logStatementAfterReturning(ResponseEntity<Student> value) {
		log.info("Executing -> method returning value->{}", "id= " + value.getBody().getId() + " Name= "
				+ value.getBody().getsName() + " Email = " + value.getBody().getEmail_Dtls().toString());

	}
}
