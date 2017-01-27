package com.gd.services;

import com.gd.dto.BookDTO;

public interface BookService {
    BookDTO getByIsbn(String isbn);
}
