package com.library.library.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.library.library.Classes.Author;
import com.library.library.Classes.Book;
import com.library.library.Classes.Genre;
import com.library.library.Classes.DTO.AuthorDTO;
import com.library.library.Classes.DTO.BookDTO;
import com.library.library.Classes.DTO.GenreDTO;
import com.library.library.Services.AuthorService;
import com.library.library.Services.BookService;
import com.library.library.Services.GenreService;

import java.util.List;

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
    public List<BookDTO> getBooks() {
        return bookService.getBooks();
    }

    @GetMapping("/books/author")
    public List<BookDTO> getBooksByAuthor(@RequestParam(name = "name") String authorName) {
        return bookService.getBooksByAuthor(authorName);
    }

    @PostMapping("/authors/add")
    public ResponseEntity<Author> addAuthor(@RequestBody Author entity) {
        authorService.addAuthor(entity);//TODO: process POST request
        
        return ResponseEntity.ok(entity);
    }

    @GetMapping("/authors/all")
    public List<AuthorDTO> getAuthors() {
        return authorService.getAuthors();
    }

    @PostMapping("/genres/add")
    public ResponseEntity<Genre> addGenre(@RequestBody Genre entity) {
        genreService.addGenre(entity);//TODO: process POST request
        
        return ResponseEntity.ok(entity);
    }
    
    @GetMapping("/genres/all")
    public List<GenreDTO> getGenres() {
        return genreService.getGenres();
    }

}