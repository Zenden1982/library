package com.library.library.Classes;

import java.util.Date;

import jakarta.persistence.*;
import lombok.Data;

@Data
public class Book {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "title" , nullable = false, length = 50)
    private String title;

    @Column(name = "author" , nullable = false, length = 50)
    private String author;

    @Column(name = "publish_date" , nullable = false)
    private Date publishDate;

    @Column(name = "isbn" , nullable = false, length = 50)
    private String isbn;
}
