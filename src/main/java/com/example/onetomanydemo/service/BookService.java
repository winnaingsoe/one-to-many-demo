package com.example.onetomanydemo.service;

import com.example.onetomanydemo.dao.AuthorDao;
import com.example.onetomanydemo.ds.Author;
import com.example.onetomanydemo.ds.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookService {
    @Autowired
    private AuthorDao authorDao;

    @Transactional
    public void authorWithThreeBooks() {
        Author author = new Author("IShiguro", "ishiguro@gmail.com", "55-55-555");

        Book book1 = new Book("A pale view of hill", LocalDate.of(1978,3,18), "Sun");
        Book book2 = new Book("Never let me go", LocalDate.of(2000, 3, 27), "Moon");
        Book book3 = new Book("The unsouled", LocalDate.of(2000,3,11), "Sun");

        author.addBook(book1);
        author.addBook(book2);
        author.addBook(book3);
        authorDao.save(author);
    }

    @Transactional
    public void insertNewBook() {
        Author author = authorDao.fetchByName("IShiguro");
        author.addBook(new Book("Clara and Sun", LocalDate.of(2021, 3,21),"Sun"));
        authorDao.save(author);
    }

    @Transactional
    public void deleteLastBook() {
      Author author =  authorDao.fetchByName("IShiguro");
        List<Book> books = author.getBooks();
        author.remove(books.get(books.size()-1));
    }

    @Transactional
    public void deleteFirstBook() {
        Author author = authorDao.fetchByName("IShiguro");
        List<Book> books = author.getBooks();
        author.remove(books.get(0));
    }
}
