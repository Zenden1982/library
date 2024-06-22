package com.library.library.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.library.Classes.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
    
}
