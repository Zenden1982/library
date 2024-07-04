package com.library.library.Repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.library.library.Classes.Book;
import com.library.library.Classes.QBook;
import com.library.library.Classes.DTO.BookDTO;
import com.library.library.Classes.DTO.BookFilter;
import com.library.library.Classes.DTO.QPredicates;
import com.querydsl.jpa.impl.JPAQuery;

import jakarta.persistence.EntityManager;


@Component
public class FilterBookRepository {
@Autowired
private BookRepository bookRepository;

    @Autowired
    private EntityManager entityManager;

    public List<Book> findAllbyFilter(BookFilter filter) {
        var predicate = QPredicates.builder().add(filter.title(), QBook.book.title::containsIgnoreCase).add(filter.author(), QBook.book.author.name::containsIgnoreCase).add(filter.genre(), QBook.book.genre.name::containsIgnoreCase).build();
        return new JPAQuery<Book>(entityManager).select(QBook.book).from(QBook.book).where(predicate).fetch();
    }

    public Page<BookDTO> findAllbyFilter(BookFilter filter, Pageable pageable) {
        var predicate = QPredicates.builder().add(filter.title(), QBook.book.title::containsIgnoreCase).add(filter.author(), QBook.book.author.name::containsIgnoreCase).add(filter.genre(), QBook.book.genre.name::containsIgnoreCase).build();
        return bookRepository.findAll(predicate, pageable).map(BookDTO::convertToDTO);
    }
}
