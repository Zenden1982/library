package com.library.library.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.library.Classes.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book> findByAuthorName(String author);
    
}
