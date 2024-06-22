package com.library.library.Classes.DTO;

import java.util.Date;

import com.library.library.Classes.Author;

import lombok.Data;

@Data
public class AuthorDTO {
    private Integer id;
    private String name;
    private Date birthDate;

    AuthorDTO(Author author){
        setId(id);
        setName(author.getName());
        setBirthDate(author.getBirthDate());
    }
}
