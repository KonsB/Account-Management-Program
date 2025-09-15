package com.bookStore.bookstore;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepo;

    public void saveBook(Book myBook) {
        bookRepo.save(myBook);
    }

    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    public Book getBookById(Integer id) {
        return bookRepo.findById(id).get();
    }

    public void deleteBookById(Integer id) {
        bookRepo.deleteById(id);
    }
}
