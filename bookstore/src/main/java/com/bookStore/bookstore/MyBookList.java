package com.bookStore.bookstore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "my_books")
public class MyBookList {

    @Id
    private Integer id;
    @Column
    private String title;
    @Column
    private String author;
    @Column
    private String price;

    public MyBookList(Integer id, String title, String author, String price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public MyBookList() {
    }

    public Integer getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
}
