package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.example")
@EnableJpaRepositories("com.example.repository")
@EntityScan(basePackages = {"com.example.entity"})
@EnableJpaAuditing
public class DemoApplication {

  private final Logger LOG = LoggerFactory.getLogger(getClass());

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }
}
