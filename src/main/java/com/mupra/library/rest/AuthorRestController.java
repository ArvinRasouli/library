package com.mupra.library.rest;

import com.mupra.library.dto.request.AddAuthorRequest;
import com.mupra.library.entity.Author;
import com.mupra.library.service.AuthorService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/author")
public class AuthorRestController {
    private final AuthorService authorService;

    public AuthorRestController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping("/add")
    public Author addAuthor(@RequestBody AddAuthorRequest addAuthorRequest){
        return authorService.addAuthor(addAuthorRequest);
    }
}
