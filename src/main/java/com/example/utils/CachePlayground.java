package com.example.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;

public class CachePlayground {
	 
    @Autowired
    private CacheManager cacheManager;

    public void add(String key, String value) {
        cacheManager.getCache("default").put(key, value);
    }

    public String getContent(String key) {
        return cacheManager.getCache("default").get(key).get().toString();
    }
}