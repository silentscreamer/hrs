package com.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.dto.User;
import com.example.repository.UserRepository;
import com.example.utils.CachePlayground;

@Controller
public class UserController {
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	/*@Cacheable(value = "users", key = "#userId", unless = "#result.followers < 12000")
	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public User getUser(@PathVariable String userId) {
	  log.info("Getting user with ID {}.", userId);
	  return userRepository.getOne(Long.valueOf(userId));
	}
	
	@RequestMapping(value = "/cacheCheck", method = RequestMethod.GET)
	public void cacheCheck() {
	  log.info("Checking Infinispan Cache...");
	  
	  cp.add("Infinispan", "Is cool!");
      System.out.println(cp.getContent("Infinispan"));
      
      log.info("Checking Infinispan Cache end...");
	}*/
}
