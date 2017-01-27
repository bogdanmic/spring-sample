package com.gd.repositories;

import com.gd.dto.BookDTO;
import org.springframework.stereotype.Repository;

@Repository
public class BookRepositoryImpl implements BookRepository{
    @Override
    public BookDTO getByIsbn(String isbn) {
        return new BookDTO(isbn, "Some book");
    }
}
