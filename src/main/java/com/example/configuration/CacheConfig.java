package com.example.configuration;

import org.infinispan.spring.provider.SpringEmbeddedCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.utils.CachePlayground;

@Configuration
public class CacheConfig {

	@Bean
	public SpringEmbeddedCacheManagerFactoryBean springCache() {
		return new SpringEmbeddedCacheManagerFactoryBean();
	}

	@Bean
	public CachePlayground playground() {
		return new CachePlayground();
	}
}
