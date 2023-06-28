package com.ssafy.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootProductApplication.class, args);
		
//		ApplicationContext context = SpringApplication.run(SpringBootProductApplication.class, args);
//		
//		String[] names = context.getBeanDefinitionNames();
//		
//		for(String name : names) {
//			System.out.println(name);
//		}
		
		
	}

}
