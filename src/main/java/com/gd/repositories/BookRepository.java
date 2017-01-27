package com.gd.repositories;

import com.gd.dto.BookDTO;

public interface BookRepository {
    BookDTO getByIsbn(String isbn);
}
