package com.sm;

import com.sm.entity.Author;
import com.sm.entity.Book;
import com.sm.repository.AuthorRepository;
import com.sm.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Author author = generateAuthor("John");
        generateBook("Win World", author);
        generateBook("Loser World", author);
        generateBook("Success Key", author);
        Author author1 = generateAuthor("Micahel");
        generateBook("Do not be loser", author1);
        generateBook("Bad man", author1);
    }

    public void generateBook(String title, Author author) {
        List<Author> authors = new ArrayList<>();
        authors.add(authorRepository.findById(author.getId()).orElse(null));

        Book book = new Book();
        book.setTitle(title);
        book.setAuthors(authors);

        bookRepository.save(book);
    }

    public Author generateAuthor(String name) {
        Author author = new Author();
        author.setName(name);
        return authorRepository.save(author);
    }
}
