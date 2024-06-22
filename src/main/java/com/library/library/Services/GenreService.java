package com.library.library.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.library.library.Classes.Genre;
import com.library.library.Repositories.GenreRepository;

import jakarta.transaction.Transactional;

import java.util.*;

@Service
public class GenreService {

    @Autowired
    private GenreRepository genreRepository;

    @Transactional
    public List<Genre> getGenres() {
        return genreRepository.findAll();
    }

    @Transactional
    public void addGenre(Genre genre) {
        genreRepository.save(genre);
    }

    @Transactional
    public void deleteGenre(int id) {
        genreRepository.deleteById(id);
    }

    @Transactional
    public Genre getGenreById(int id) {
        return genreRepository.findById(id).get();
    }
}
