package com.library.library.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.library.Classes.Genre;

public interface GenreRepository extends JpaRepository<Genre, Integer> {
    
}
