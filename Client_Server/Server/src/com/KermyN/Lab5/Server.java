package com.KermyN.Lab5;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;


public class Server {

    public static final int PORT = 8888;

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        final ServerSocketChannel serverChannel = ServerSocketChannel.open();
        serverChannel.bind(new InetSocketAddress("localhost", PORT));

        while (true) {
            SocketChannel socketChannel = serverChannel.accept();
            while (socketChannel.isConnected()) {
                ObjectInputStream ois =
                        new ObjectInputStream(socketChannel.socket().getInputStream());
                ////Считываем серилизованный обьект приводя его нужному классу
                ///логика работы с  полученным обьектом
                Employee input = (Employee)ois.readObject();
                input.Name += "from server";
                input.Age+=20;
                ///запись серилизованного ответа
                ObjectOutputStream oos = new
                        ObjectOutputStream(socketChannel.socket().getOutputStream());
                oos.writeObject(input);
            }
        }
    }
}
