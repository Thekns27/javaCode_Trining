package org.example.methodsecuritydemo.service;

import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;

@Service
public class BookService {
    public List<Book> sellBooks(List<Book> books) {
        return books;
    }
}
