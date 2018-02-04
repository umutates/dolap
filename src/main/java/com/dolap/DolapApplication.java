package com.dolap;

import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.transaction.BeforeTransaction;

import com.dolap.entity.User;
import com.dolap.service.impl.UserService;
import com.dolap.util.Role;

@SpringBootApplication
public class DolapApplication {

	public static void main(String[] args) {
		SpringApplication.run(DolapApplication.class, args);
		
	}
	
	@Bean  
	public SessionFactory sessionFactory(HibernateEntityManagerFactory hemf){  
	    return hemf.getSessionFactory();  
	}   
	
}
