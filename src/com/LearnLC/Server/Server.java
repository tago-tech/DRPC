package com.LearnLC.Server;

import com.LearnLC.RAPI.Book;
import com.LearnLC.RAPI.Constants;
import com.LearnLC.RAPI.QueryBookService;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main (String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(Constants.port);
        while (true) {
            Socket socket = serverSocket.accept();
            process(socket);
            socket.close();
        }
    }
    public static void process (Socket socket) throws IOException {

        System.out.println("Connected : " + socket.toString());
        //get output and input
        OutputStream outputStream = socket.getOutputStream();
        InputStream inputStream = socket.getInputStream();
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        Integer id = dataInputStream.readInt();

        QueryBookService queryBookService = new QueryBookServiceImp();
        Book book = queryBookService.queryBooksById(id);

        dataOutputStream.writeInt(book.getId());
        dataOutputStream.writeUTF(book.getBookName());
        dataOutputStream.flush();

        dataInputStream.close();
        dataOutputStream.close();
        outputStream.close();
        inputStream.close();
    }

}
