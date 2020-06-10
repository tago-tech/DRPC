package com.LearnLC.Server;

import com.LearnLC.RAPI.Book;
import com.LearnLC.RAPI.QueryBookService;

/**
 * 服务端实现服务的实体类
 * */
public class QueryBookServiceImp implements QueryBookService {
    @Override
    public Book queryBooksById(Integer id) {
        return new Book("Wars and Peace",id);
    }
    @Override
    public Book queryBooksByName(String name) {
        return new Book(name,-1);
    }
    @Override
    public Book queryBooks(Integer id, String name) {
        return new Book(name,id);
    }
}
