package com.LearnLC.Client;

import com.LearnLC.RAPI.Book;
import com.LearnLC.RAPI.Constants;
import com.LearnLC.RAPI.QueryBookService;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * 在服务器端尝试调用远程方法
 * */
public class Client {
    public static void main (String[] args) throws IOException {
        QueryBookService queryBookService = Stub.getStub();
        System.out.println(queryBookService.queryBooksById(456));
    }
}
