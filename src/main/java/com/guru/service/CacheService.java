package com.guru.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CacheService {
	Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CacheManager cacheManager;

    public void evictAllCaches() {
    	cacheManager.getCacheNames().stream()
        .forEach(cacheName -> {
        	logger.info("cacheName -> :{}",cacheName);
        	cacheManager.getCache(cacheName).clear();
        	});
//        cacheManager.getCacheNames().stream()
//          .forEach(cacheName -> cacheManager.getCache(cacheName).clear());
    }

    @Scheduled(fixedRate = 60000)
    public void evictAllcachesAtIntervals() {
    	logger.info("CALLING CACHE EVECT :::::::::::::::::");
        evictAllCaches();
    }

}