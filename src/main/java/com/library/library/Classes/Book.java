package com.library.library.Classes;

import java.util.Date;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name = "book")
@ToString(exclude = {"author", "genre"})
public class Book {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "title" , nullable = false, length = 50)
    private String title;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    private Author author;

    @Column(name = "publish_date" , nullable = false)
    private Date publishDate;

    @Column(name = "isbn" , nullable = false, length = 50)
    private String isbn;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "genre_id")
    private Genre genre;

}
