package com.bookStore.bookstore;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyBookService {

    @Autowired
    private MyBookRepository myBookRepo;

    public void saveMyBook(MyBookList myBook) {
        myBookRepo.save(myBook);
    }

    public List<MyBookList> getAllMyBooks() {
        return myBookRepo.findAll();
    }

    public void deleteMyBookById(Integer id) {
        myBookRepo.deleteById(id);
    }

}
