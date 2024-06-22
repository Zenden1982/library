package com.library.library.Classes.DTO;

import java.util.Date;

import com.library.library.Classes.Book;

import lombok.Data;

@Data
public class BookDTO {

    private Integer id;
    private String title;
    private AuthorDTO author;
    private Date publishDate;
    private String isbn;
    private GenreDTO genre;

    public static BookDTO convertToDTO(Book book) {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(book.getId());
        bookDTO.setTitle(book.getTitle());
        bookDTO.setAuthor(AuthorDTO.convertToDTO(book.getAuthor()));
        bookDTO.setPublishDate(book.getPublishDate());
        bookDTO.setIsbn(book.getIsbn());
        bookDTO.setGenre(GenreDTO.convertToDTO(book.getGenre()));
        return bookDTO;
    }
}
