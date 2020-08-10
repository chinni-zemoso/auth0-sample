package com.zemoso.auth0.auth0sample.controller;

import com.zemoso.auth0.auth0sample.entity.Book;
import com.zemoso.auth0.auth0sample.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class BookController {

    public BookController(BookService courseManagementService) {
        this.bookManagementService = courseManagementService;
    }

    private BookService bookManagementService;

    @GetMapping("/books")
    public Map<Integer, Book> getAllBooks() {
        return bookManagementService.findAll();
    }

    @GetMapping("/books/{bookId}")
    public String getBook(@PathVariable("bookId") Integer bookId) {
        return bookManagementService.getBookByBookId(bookId);
    }

    @PostMapping("/books")
    public Book createBook(@RequestBody Book book) {
        return bookManagementService.createBook(book);
    }

    @PutMapping("/books/{bookId}")
    public Book updateBook(@RequestBody Book book, @PathVariable("bookId") Integer bookId) {
        return bookManagementService.updateBook(bookId, book);
    }

    @DeleteMapping("/books/{bookId}")
    public void deleteBook(@PathVariable("bookId") Integer bookId) {
        bookManagementService.deleteBook(bookId);
    }
}