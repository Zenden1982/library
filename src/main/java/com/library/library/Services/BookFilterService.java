package com.library.library.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.library.library.Classes.DTO.BookDTO;
import com.library.library.Classes.DTO.BookFilter;
import com.library.library.Repositories.FilterBookRepository;

import jakarta.persistence.EntityManager;

@Component
public class BookFilterService {
    
    @Autowired
    private EntityManager entityManager;

    @Autowired
    private FilterBookRepository filterBookRepository;

    public List<BookDTO> findAllbyFilter(BookFilter filter) {
        return filterBookRepository.findAllbyFilter(filter).stream().map(BookDTO::convertToDTO).toList();
    }

    // public List<BookDTO> findAllbyFilter(BookFilter filter, Pageable pageable) {
    //     return filterBookRepository.findAllbyFilter(filter, pageable).stream().map(BookDTO::convertToDTO).toList();
    // }

    
}
