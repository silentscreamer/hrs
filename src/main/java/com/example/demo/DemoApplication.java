package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import com.example.utils.CachePlayground;
import com.example.utils.StackPlayground;

@SpringBootApplication
@EnableCaching
public class DemoApplication {
	
	@Autowired
	CachePlayground cp;
	
	private final Logger LOG = LoggerFactory.getLogger(getClass());

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		
		StackPlayground sp = new StackPlayground(10);
		sp.push(12);
		sp.push(10);
		System.out.println(sp.peek());
	}
}
