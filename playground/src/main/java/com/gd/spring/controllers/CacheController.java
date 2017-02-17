package com.gd.spring.controllers;

import com.gd.spring.annotations.Loggable;
import com.gd.spring.dto.BookDTO;
import com.gd.spring.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CacheController {


    private final BookService service;

    @Autowired
    public CacheController(BookService service) {
        // Here we have a constructor Spring Bean injection.
        this.service = service;
    }

    @Loggable
    @RequestMapping(value = "/book/{isbn}", method = RequestMethod.GET)
    public
    @ResponseBody
    BookDTO getBook(@PathVariable("isbn") String isbn) {
        return service.getByIsbn(isbn);
    }
}
