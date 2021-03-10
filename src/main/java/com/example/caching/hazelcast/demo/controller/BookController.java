package com.example.caching.hazelcast.demo.controller;

import com.example.caching.hazelcast.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/get-book-with-permanent-cache/{isbn}")
    public String getBookNameByIsbnWithPermanentCache(@PathVariable("isbn") String isbn) {
        return bookService.getBookNameByIsbnWithPermanentCache(isbn);
    }

    @GetMapping("/get-book-with-thirty-seconds-cache/{isbn}")
    public String getBookNameByIsbnWithThirtySecondsCache(@PathVariable("isbn") String isbn) {
        return bookService.getBookNameByIsbnWithThirtySecondsCache(isbn);
    }

    @PostMapping(value = {"/evict-all-caches"})
    public void evictAllCacheValues() {
        bookService.evictAllCacheValues();
    }

}