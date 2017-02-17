package com.gd.spring.services;


import com.gd.spring.dto.BookDTO;

public interface BookService {
    BookDTO getByIsbn(String isbn);
}
