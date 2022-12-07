package com.example.onetomanydemo.ds;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private LocalDate yearPublished;
    private String publisher;

    @ManyToOne @JoinColumn(name = "author_id_fk")
    private Author author;

    public Book() {

    }

    public Book(String title, LocalDate yearPublished, String publisher) {
        this.title = title;
        this.yearPublished = yearPublished;
        this.publisher = publisher;
    }
}
