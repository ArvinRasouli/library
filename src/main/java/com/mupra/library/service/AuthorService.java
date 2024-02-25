package com.mupra.library.service;

import com.mupra.library.dto.request.AddAuthorRequest;
import com.mupra.library.entity.Author;

public interface AuthorService {
    Author addAuthor(AddAuthorRequest addAuthorRequest);

    Author getAuthorById(int id);
}
