package com.sm.repository;

import com.sm.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT b FROM Book b JOIN b.authors a WHERE a.name = :name")
    List<Book> findByAuthorName(@Param("name") String name);

    @Query("SELECT b FROM Book b WHERE b.id IN "
            + " (SELECT DISTINCT b2.id FROM Book b2 JOIN b2.authors a "
            + "     WHERE a IN "
            + "         (SELECT a2 FROM Author a2 JOIN a2.books b3 GROUP BY a2 HAVING COUNT(b3) >= 3)" +
            "   )")
    List<Book> findBooksByAuthorsWithMoreThan3Books();

}
