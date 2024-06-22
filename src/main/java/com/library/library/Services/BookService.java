package com.library.library.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.library.Classes.Book;
import com.library.library.Repositories.BookRepository;

import jakarta.transaction.Transactional;

import java.util.*;
import com.library.library.Classes.DTO.BookDTO;
import com.library.library.Classes.DTO.AuthorDTO;
import com.library.library.Classes.DTO.GenreDTO;

@Service
public class BookService {
    
    @Autowired
    private BookRepository bookRepository;

    public List<BookDTO> getBooks() {
        return bookRepository.findAll().stream().map(BookDTO::convertToDTO).toList();
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
    public BookDTO getBookById(int id) {
        return BookDTO.convertToDTO(bookRepository.findById(id).get());
    }

    @Transactional
    public void updateBook(Book book) {
        bookRepository.save(book);
    }

    @Transactional
    public List<BookDTO> getBooksByAuthor(String author) {
        return bookRepository.findByAuthorName(author).stream().map(BookDTO::convertToDTO).toList();
    }

}
