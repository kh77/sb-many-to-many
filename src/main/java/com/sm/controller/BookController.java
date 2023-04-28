package com.sm.controller;

import com.sm.dto.BookDto;
import com.sm.entity.Book;
import com.sm.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService service;

    @GetMapping("/author/{name}")
    public List<BookDto> findByAuthorName(@PathVariable String name) {
        return service.findByAuthorName(name);
    }

    @GetMapping
    public List<BookDto>findAll() {
        return service.findBooksByAuthorsWithMoreThan3Books();
    }

}


