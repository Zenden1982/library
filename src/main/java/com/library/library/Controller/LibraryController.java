package com.library.library.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/library")
@Tag(name = "Библиотека", description = "Операции, связанные с управлением библиотекой")
public class LibraryController {

    @Autowired
    BookService bookService;

    @Autowired
    AuthorService authorService;

    @Autowired
    GenreService genreService;

    @PostMapping("/books/add")
    @Operation(summary = "Добавить новую книгу", description = "Добавление новой книги в библиотеку")
    @ApiResponse(responseCode = "200", description = "Книга успешно добавлена")
    public ResponseEntity<BookDTO> addBook(@RequestBody Book entity) {
        bookService.addBook(entity);
        BookDTO entityDTO = BookDTO.convertToDTO(entity);
        log.info("addBook: " + entityDTO);
        return ResponseEntity.ok(entityDTO);
    }
    
    @GetMapping("/books/all")
    @Operation(summary = "Получить все книги", description = "Получение списка всех книг в библиотеке")
    public List<BookDTO> getBooks() {
        log.info("getBooks: ");
        return bookService.getBooks();
    }

    @GetMapping("/books/author")
    @Operation(summary = "Получить книги по автору", description = "Получение списка книг по указанному автору")
    public List<BookDTO> getBooksByAuthor(@RequestParam(name = "name") String authorName) {
        return bookService.getBooksByAuthor(authorName);
    }

    @PostMapping("/authors/add")
    @Operation(summary = "Добавить нового автора", description = "Добавление нового автора в библиотеку")
    @ApiResponse(responseCode = "200", description = "Автор успешно добавлен")
    public ResponseEntity<Author> addAuthor(@RequestBody Author entity) {
        authorService.addAuthor(entity);
        return ResponseEntity.ok(entity);
    }

    @GetMapping("/authors/all")
    @Operation(summary = "Получить всех авторов", description = "Получение списка всех авторов в библиотеке")
    public List<AuthorDTO> getAuthors() {
        return authorService.getAuthors();
    }

    @PostMapping("/genres/add")
    @Operation(summary = "Добавить новый жанр", description = "Добавление нового жанра в библиотеку")
    @ApiResponse(responseCode = "200", description = "Жанр успешно добавлен")
    public ResponseEntity<Genre> addGenre(@RequestBody Genre entity) {
        genreService.addGenre(entity);
        return ResponseEntity.ok(entity);
    }
    
    @GetMapping("/genres/all")
    @Operation(summary = "Получить все жанры", description = "Получение списка всех жанров в библиотеке")
    public List<GenreDTO> getGenres() {
        return genreService.getGenres();
    }
}
