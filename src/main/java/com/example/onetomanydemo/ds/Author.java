package com.example.onetomanydemo.ds;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Entity
@Getter
@Setter
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    private String phoneNumber;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Book> books = new ArrayList<>();

    public Author() {

    }

    public Author(String name, String email, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public void remove(Book book) {
        books.remove(book);
    }

    public void removeAll() {
        Iterator<Book> itr = books.iterator();
        while (itr.hasNext()) {
            itr.remove();
        }
    }

    public void addBook(Book book) {
        book.setAuthor(this);
        this.books.add(book);
    }
}
