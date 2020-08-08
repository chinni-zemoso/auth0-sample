package com.zemoso.auth0.auth0sample.service;

import com.zemoso.auth0.auth0sample.entity.Book;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class BookService {

    private static Map<Integer, Book> books = new HashMap<>();
    private static Integer idCounter = 1;

    static {
        books.put(idCounter++, new Book("chinni-achari", "PHYSICS"));
        books.put(idCounter++, new Book("chinni-achari", "CHEMISTRY"));
        books.put(idCounter++, new Book("chinni-achari", "MATHS"));
        books.put(idCounter++, new Book("chinni-achari", "SANSKRIT"));
    }

    public Map<Integer, Book> findAll() {
        return books;
    }

    public String getBookByBookId(Integer bookId) {
        Book book=books.get(bookId);
        return (book==null)?"Book Doesnt exists":book.toString();
    }

    public Book createBook(Book book) {
        book.setDescription("java version-"+idCounter+1);
        books.put(idCounter++, book);
        return book;
    }

    public Book updateBook(Integer id, Book book) {
        Book legacyBook = books.get(id);
        if (legacyBook != null) {
            books.put(id, book);
        }
        return book;
    }

    public void deleteBook(Integer id) {
        Book legacyBook = books.get(id);
        if (legacyBook != null) {
            books.remove(id);
        }
    }
}
