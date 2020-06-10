package com.LearnLC.RAPI;

import java.io.Serializable;

public class Book implements Serializable {
    String bookName;
    int id;

    public Book(String bookName, int id) {
        this.bookName = bookName;
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", id=" + id +
                '}';
    }
}
