package com.library.library.Classes.DTO;


import com.library.library.Classes.Genre;

import lombok.Data;

@Data
public class GenreDTO {
    private Integer id;
    private String name;

    public static GenreDTO convertToDTO(Genre genre) {
        GenreDTO genreDTO = new GenreDTO();
        genreDTO.setId(genre.getId());
        genreDTO.setName(genre.getName());
        return genreDTO;
    }
}
