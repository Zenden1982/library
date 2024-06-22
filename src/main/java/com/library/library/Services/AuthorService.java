package com.library.library.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.library.library.Classes.Author;
import com.library.library.Repositories.AuthorRepository;
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
    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }

    @Transactional
    public void deleteAuthor(int id) {
        authorRepository.deleteById(id);
    }

    @Transactional
    public Author getAuthorById(int id) {
        return authorRepository.findById(id).get();
    }
}
