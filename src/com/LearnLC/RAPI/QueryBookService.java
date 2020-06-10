package com.LearnLC.RAPI;

/**
 * 书籍查询接口
 * */
public interface QueryBookService {
    public Book queryBooksById (Integer id);
    public Book queryBooksByName (String name);
    public Book queryBooks (Integer id,String name);
}
