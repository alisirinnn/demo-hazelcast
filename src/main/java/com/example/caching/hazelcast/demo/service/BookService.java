package com.example.caching.hazelcast.demo.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import static com.example.caching.hazelcast.demo.common.CacheConstants.MAP_THIRTY_SECONDS_CACHE;

@Service
public class BookService {

    @Cacheable("books")
    public String getBookNameByIsbnWithPermanentCache(String isbn) {
        return findBookInSlowSource(isbn);
    }

    @Cacheable(value = MAP_THIRTY_SECONDS_CACHE, key = "{#root.targetClass.name,#root.methodName,#isbn}")
    public String getBookNameByIsbnWithThirtySecondsCache(String isbn) {
        return findBookInSlowSource(isbn);
    }

    @CacheEvict(value = "books", allEntries = true)
    public void evictAllCacheValues() {
    }

    private String findBookInSlowSource(String isbn) {
        // some long processing
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Sample Book Name";
    }

}