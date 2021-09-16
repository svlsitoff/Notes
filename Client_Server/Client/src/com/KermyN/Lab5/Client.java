package com.KermyN.Lab5;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;


public class Client {

    public static void main(String[] args) throws IOException {
        InetSocketAddress socketAddress = new InetSocketAddress("localhost",
                8888);
         SocketChannel socketChannel = SocketChannel.open();
        try  {
            socketChannel.connect(socketAddress);
            while (true) {
                ////Создаем обьект
                Employee emp = new Employee("Kolyan",36);
                //серилизуем и отрпаляем на сервер
                ObjectOutputStream oos = new
                        ObjectOutputStream(socketChannel.socket().getOutputStream());
                oos.writeObject(emp);
                //получаем ответ от сервера
                ObjectInputStream ois =
                        new ObjectInputStream(socketChannel.socket().getInputStream());

                Employee empget = (Employee) ois.readObject();
                System.out.println(empget.toString());
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}