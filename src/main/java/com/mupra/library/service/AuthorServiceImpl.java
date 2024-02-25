package com.mupra.library.service;

import com.mupra.library.dao.AuthorDAO;
import com.mupra.library.dto.request.AddAuthorRequest;
import com.mupra.library.entity.Author;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService{
    private final AuthorDAO authorDAO;

    public AuthorServiceImpl(AuthorDAO authorDAO) {
        this.authorDAO = authorDAO;
    }

    @Override
    public Author addAuthor(AddAuthorRequest addAuthorRequest) {
        Author author = new Author(addAuthorRequest.getName(), addAuthorRequest.getBirthDate());
        return authorDAO.save(author);
    }

    @Override
    public Author getAuthorById(int id) {
        return authorDAO.findById(id).orElseThrow(
                () -> new RuntimeException("Author not exist")
        );
    }
}
