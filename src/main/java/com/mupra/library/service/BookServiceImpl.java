package com.mupra.library.service;

import com.mupra.library.dao.BookDAO;
import com.mupra.library.dto.request.AddBookRequest;
import com.mupra.library.entity.Author;
import com.mupra.library.entity.Book;
import com.mupra.library.entity.Publisher;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService{

    private final BookDAO bookDAO;

    private final PublisherService publisherService;

    private final AuthorService authorService;


    public BookServiceImpl(BookDAO bookDAO, PublisherService publisherService, AuthorService authorService) {
        this.bookDAO = bookDAO;
        this.publisherService = publisherService;
        this.authorService = authorService;
    }

    @Override
    public Book addBook(AddBookRequest addBookRequest) {
        Book book = new Book();
        Publisher publisherById = publisherService.getPublisherById(addBookRequest.getPublisherId());
        Author authorById = authorService.getAuthorById(addBookRequest.getAuthorId());
        book.setName(addBookRequest.getName());
        book.setInventory(addBookRequest.getInventory());
        book.setPrintYear(addBookRequest.getPrintYear());
        book.setPublisher(publisherById);
        book.setAuthor(authorById);

        return bookDAO.save(book);
    }
}
