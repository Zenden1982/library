package com.library.library.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.library.Classes.Book;
import com.library.library.Services.AuthorService;
import com.library.library.Services.BookService;
import com.library.library.Services.GenreService;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/library")
public class LibraryController {

    @Autowired
    BookService bookService;

    @Autowired
    AuthorService authorService;

    @Autowired
    GenreService genreService;

    @PostMapping("/books/add")
    public ResponseEntity<Book> addBook(@RequestBody Book entity) {
        bookService.addBook(entity);//TODO: process POST request
        
        return ResponseEntity.ok(entity);
    }
    
    @GetMapping("/books/all")
    public String getBooks() {
        return bookService.getBooks().toString();
    }
    

}