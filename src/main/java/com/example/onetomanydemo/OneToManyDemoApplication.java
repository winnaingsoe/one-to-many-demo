package com.example.onetomanydemo;

import com.example.onetomanydemo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OneToManyDemoApplication {

    @Autowired
    private BookService bookService;
    public static void main(String[] args) {
        SpringApplication.run(OneToManyDemoApplication.class, args);
    }

    @Bean
    public ApplicationRunner runner() {
        return r -> {
            System.out.println("create author with three books...");
            bookService.authorWithThreeBooks();
            System.out.println();
            System.out.println("insert new book............");
            bookService.insertNewBook();
            System.out.println();
            System.out.println("delete last book.........");
            bookService.deleteLastBook();
            System.out.println();
            System.out.println("delete first book.........");
            bookService.deleteFirstBook();
        };
    }

}
