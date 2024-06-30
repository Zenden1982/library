package com.library.library.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.library.library.Classes.Author;
import com.library.library.Classes.DTO.AuthorDTO;
import com.library.library.Repositories.AuthorRepository;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

import org.springframework.transaction.annotation.Transactional;

@Service

public class AuthorService {
    
    @Autowired
    private AuthorRepository authorRepository;

    @Transactional
    public void addAuthor(Author author) {
        authorRepository.save(author);
    }

    @Transactional
    public List<AuthorDTO> getAuthors() {
        return authorRepository.findAll().stream().map(AuthorDTO::convertToDTO).toList();
    }

    @Transactional
    public void deleteAuthor(int id) {
        authorRepository.deleteById(id);
    }

    @Transactional
    public AuthorDTO getAuthorById(int id) {
        return AuthorDTO.convertToDTO(authorRepository.findById(id).get());
    }
}
