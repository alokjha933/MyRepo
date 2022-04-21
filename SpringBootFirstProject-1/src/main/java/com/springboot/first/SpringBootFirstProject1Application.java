package com.springboot.first;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBootFirstProject1Application {

	public static void main(String[] args) {

		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring.xml");
		Alien a=(Alien)applicationContext.getBean("alien");
		a.show();
		System.out.println(a.getRollNo());
		
		
	}

}
