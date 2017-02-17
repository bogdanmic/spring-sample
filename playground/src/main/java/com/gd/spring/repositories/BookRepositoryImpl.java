package com.gd.spring.repositories;

import com.gd.spring.dto.BookDTO;
import org.springframework.stereotype.Repository;

@Repository
public class BookRepositoryImpl implements BookRepository{
    @Override
    public BookDTO getByIsbn(String isbn) {
        return new BookDTO(isbn, "Some book");
    }
}
