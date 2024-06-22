package com.library.library.Classes.DTO;

import java.util.Date;
import java.util.List;

import com.library.library.Classes.Author;

import lombok.Data;

@Data
public class AuthorDTO {
    private Integer id;
    private String name;
    private Date birthDate;

   public static AuthorDTO convertToDTO(Author author){
        AuthorDTO authorDTO = new AuthorDTO();
        authorDTO.setId(author.getId());
        authorDTO.setName(author.getName());
        authorDTO.setBirthDate(author.getBirthDate());
        return authorDTO;
    }
}
