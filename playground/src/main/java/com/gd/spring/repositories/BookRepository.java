package com.gd.spring.repositories;


import com.gd.spring.dto.BookDTO;

public interface BookRepository {
    BookDTO getByIsbn(String isbn);
}
