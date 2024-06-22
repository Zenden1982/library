package com.library.library.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.library.Classes.Book;
import com.library.library.Repositories.BookRepository;

import jakarta.transaction.Transactional;

import java.util.*;
@Service
public class BookService {
    
    @Autowired
    private BookRepository bookRepository;

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @Transactional
    public void addBook(Book book) {
        bookRepository.save(book);
    }

    @Transactional
    public void deleteBook(int id) {
        bookRepository.deleteById(id);
    }

    @Transactional
    public Book getBookById(int id) {
        return bookRepository.findById(id).get();
    }

    @Transactional
    public void updateBook(Book book) {
        bookRepository.save(book);
    }

    @Transactional
    public List<Book> getBooksByAuthor(String author) {
        return bookRepository.findByAuthorName(author);
    }

}
