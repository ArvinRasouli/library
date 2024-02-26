package com.mupra.library.service;

import com.mupra.library.dao.BookDAO;
import com.mupra.library.dto.request.AddBookRequest;
import com.mupra.library.entity.Author;
import com.mupra.library.entity.Book;
import com.mupra.library.entity.Publisher;
import org.springframework.stereotype.Service;

import java.util.List;

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

        if (book.getName().length() > 100) {
            throw new RuntimeException("The length of the book name exceeds the limit");
        }

        if (book.getName().isEmpty()) {
            throw new RuntimeException("book name field cannot be empty");
        }

        if (book.getPrintYear() > 1402 || book.getPrintYear() <= 0 ) {
            throw new RuntimeException("The data entered in the year of print field is invalid");
        }

        if (book.getInventory() < 0) {
            throw new RuntimeException("The inventory field data cannot be smaller than 0");
        }

        return bookDAO.save(book);
    }

    @Override
    public List<Book> findAllBook() {
        return bookDAO.findAll();
    }

    @Override
    public void changeInventoryAllBooks() {
        List<Book> allBook = bookDAO.findAll();
        for (Book book : allBook) {
            book.setInventory(10);

        }

        bookDAO.saveAll(allBook);
    }
}
