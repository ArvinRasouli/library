package com.mupra.library.service;

import com.mupra.library.dto.request.AddBookRequest;
import com.mupra.library.entity.Book;

import java.util.List;

public interface BookService {
    Book addBook(AddBookRequest addBookRequest);

    List<Book> findAllBook();
}
