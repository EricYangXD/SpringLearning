package org.example;

import org.example.dao.BookDao;
import org.example.dao.impl.BookDaoImpl;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        BookDao bookDao=new BookDaoImpl();
        bookDao.save();
    }
}