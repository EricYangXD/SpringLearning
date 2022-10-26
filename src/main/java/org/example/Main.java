package org.example;

import org.example.service.BookService;
import org.example.service.impl.BookServiceImpl;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        BookService bookService =new BookServiceImpl();
        bookService.save();
    }
}