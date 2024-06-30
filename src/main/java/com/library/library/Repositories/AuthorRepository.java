package com.library.library.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.library.Classes.Author;
import java.util.List;
import java.util.Optional;


public interface AuthorRepository extends JpaRepository<Author, Integer> {
        Optional<Author> findByName(String name);
}
