package com.library.library.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.library.library.Classes.Genre;
import com.library.library.Repositories.GenreRepository;

import jakarta.transaction.Transactional;

import java.util.*;

import com.library.library.Classes.DTO.GenreDTO;
import com.library.library.Repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GenreService {

    @Autowired
    private GenreRepository genreRepository;

    @Transactional
    public List<GenreDTO> getGenres() {
        return genreRepository.findAll().stream().map(GenreDTO::convertToDTO).collect(Collectors.toList());
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
    public GenreDTO getGenreById(int id) {
        return GenreDTO.convertToDTO(genreRepository.findById(id).get());
    }
}
