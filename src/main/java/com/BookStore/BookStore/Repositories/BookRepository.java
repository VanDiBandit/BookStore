package com.BookStore.BookStore.Repositories;

import com.BookStore.BookStore.Models.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

    Iterable<Book> findByCategoryId(Long categoryId);

    @Query(value = "Select * From book WHERE name LIKE CONCAT('%', :query, '%')", nativeQuery = true)
    Iterable<Book> searchBooks(String query);
}
