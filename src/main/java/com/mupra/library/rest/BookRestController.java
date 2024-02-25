package com.mupra.library.rest;

import com.mupra.library.dto.request.AddBookRequest;
import com.mupra.library.entity.Book;
import com.mupra.library.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookRestController {

    private final BookService bookService;

    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/add")
    public Book addBook(@RequestBody AddBookRequest addBookRequest) {
        return bookService.addBook(addBookRequest);
    }

    @GetMapping("/all")
    public List<Book> findAllBook() {
        return bookService.findAllBook();
    }
}
