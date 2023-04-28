package com.sm.service;

import com.sm.dto.AuthorDto;
import com.sm.dto.BookDto;
import com.sm.entity.Book;
import com.sm.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor
public class BookService {
    private final BookRepository bookRepository;


    public List<BookDto> findByAuthorName(String authorName) {
        List<Book> books = bookRepository.findByAuthorName(authorName);
        List<BookDto> bookDtoList = copyBookAndAuthor(books);
        return bookDtoList;
    }

    public List<BookDto> findBooksByAuthorsWithMoreThan3Books() {
        List<Book> books = bookRepository.findBooksByAuthorsWithMoreThan3Books();
        List<BookDto> bookDtoList = copyBookAndAuthor(books);
        return bookDtoList;
    }

    public List<BookDto> copyBookAndAuthor(List<Book> books) {
        List<BookDto> bookDtoList = new ArrayList<>();
        if (!books.isEmpty()) {
            for (Book copyBook : books) {
                BookDto bookDto = new BookDto();
                AuthorDto authorDto = new AuthorDto();
                BeanUtils.copyProperties(copyBook, bookDto);
                BeanUtils.copyProperties(copyBook.getAuthors().get(0), authorDto);
                bookDto.setAuthors(Arrays.asList(authorDto));
                bookDtoList.add(bookDto);
            }
        }
        return bookDtoList;
    }

}
