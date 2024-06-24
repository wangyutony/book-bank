package com.harbada.bookbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harbada.bookbank.entity.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface BookRepository extends JpaRepository<Book, Integer> {
    //find book by author ID via native query
    @Query(value = "select b.* from react.book b join react.author_book a on b.id = a.book_id where a.author_id = ?1", nativeQuery = true)
    Set<Book> findBooksByAuthorId(@Param("author_id") Integer authorId);
}
