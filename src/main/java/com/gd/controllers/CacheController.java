package com.gd.controllers;

import com.gd.annotations.Loggable;
import com.gd.dto.BookDTO;
import com.gd.services.BookService;
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
