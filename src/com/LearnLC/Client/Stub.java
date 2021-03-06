package com.LearnLC.Client;

import com.LearnLC.RAPI.Book;
import com.LearnLC.RAPI.Constants;
import com.LearnLC.RAPI.QueryBookService;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;

public class Stub {
    public static QueryBookService getStub () {
        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //connect server
                Socket socket = new Socket(Constants.url,Constants.port);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                //远程对象方法名
                String methodName = method.getName();
                //远程方法参数类型
                Class[] paramtersTye = method.getParameterTypes();

                //分别将方法名，参数类型传递到远程服务器
                objectOutputStream.writeUTF(methodName);
                objectOutputStream.writeObject(paramtersTye);
                objectOutputStream.writeObject(args);
                objectOutputStream.flush();

                //获取远端调用结果
                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                Book book = (Book)objectInputStream.readObject();

                //流关闭
                objectInputStream.close();
                objectOutputStream.close();
                socket.close();
                return book;
            }
        };
        /**
         * 动态代理
         * JVM 会根据接口的 class 类动态创建一个代理类对象，
         * 这个代理对象实现了传入的接口，也就是说它拥有了接口中所有方法的实现。
         * 方法具体的实现可以由用户指定，也就是调用InvocationHandler的invoke方法
         * */
        Object object = Proxy.newProxyInstance(QueryBookService.class.getClassLoader(),new Class[]{QueryBookService.class},invocationHandler);
        //返回代理结果
        return (QueryBookService) object;
    }
}
