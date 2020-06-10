package com.LearnLC.Server;

import com.LearnLC.RAPI.Book;
import com.LearnLC.RAPI.Constants;
import com.LearnLC.RAPI.QueryBookService;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main (String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(Constants.port);
        while (true) {
            Socket socket = serverSocket.accept();
            process(socket);
            socket.close();
        }
    }
    /**
     * 解析具体的请求
     * */
    public static void process (Socket socket) throws Exception {

        System.out.println("Connected : " + socket.toString());
        //get output and input
        OutputStream outputStream = null;
        InputStream inputStream = null;
        ObjectInputStream objectInputStream = null;
        ObjectOutputStream objectOutputStream = null;
        //get output and input
        outputStream = socket.getOutputStream();
        inputStream = socket.getInputStream();
        objectInputStream = new ObjectInputStream(inputStream);
        objectOutputStream = new ObjectOutputStream(outputStream);

        //parse method
        String methodName = objectInputStream.readUTF();
        //parse paramters type thinking overload
        Class[] paramtersTye = (Class[]) objectInputStream.readObject();
        //parse paramters
        Object[] args = (Object[])objectInputStream.readObject();

        //service
        QueryBookService queryBookService = new QueryBookServiceImp();
        //reflect apply
        Method method = queryBookService.getClass().getMethod(methodName,paramtersTye);
        Book book = (Book)method.invoke(queryBookService,args);

        //output result
        objectOutputStream.writeObject(book);



    }

}
