package com.LearnLC.Client;

import com.LearnLC.RAPI.Book;
import com.LearnLC.RAPI.Constants;

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
        //Socket create
        Socket socket = new Socket(Constants.url,Constants.port);
        //output stream create
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        //
        int id = 112;
        dataOutputStream.writeInt(id);
        socket.getOutputStream().write(outputStream.toByteArray());
        socket.getOutputStream().flush();
        //recv from Server
        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        Integer idOfBook = dataInputStream.readInt();
        String nameOfBook = dataInputStream.readUTF();
        Book book = new Book(nameOfBook,idOfBook);
        System.out.println(book);
        dataOutputStream.close();
        outputStream.close();
        socket.close();
    }
}
