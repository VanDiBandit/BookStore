package com.BookStore.BookStore.Controllers;

import com.BookStore.BookStore.Models.Book;
import com.BookStore.BookStore.Services.BookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {

    @Autowired
    private BookServices bookServices;

    @PostMapping("/books/{categoryId}/books")
    public void createBook(@PathVariable(value = "categoryId") Long categoryId, @RequestBody Book book){
        bookServices.createBook(categoryId, book);
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<?> getBookById(@PathVariable Long id){
        return bookServices.getBookById(id);
    }

    @GetMapping("/books")
    public Iterable<Book> getAllBooks() {
        return bookServices.getAllBooks();
    }

    @PutMapping("/books/{categoryId}/books")
    public void updateBookById(@PathVariable Long categoryId, @RequestBody Book book){
        bookServices.updateBookById(categoryId, book);
    }

    @DeleteMapping("/books/{id}")
    public void deleteBookById(@PathVariable Long id){
        bookServices.deleteBookById(id);
    }

    @GetMapping("/books/{categoryId}/books")
    public Iterable<Book> findByCategoryId(@PathVariable Long categoryId){
        return bookServices.findByCategoryId(categoryId);
    }
    @GetMapping("/searchBooks")
    public Iterable<Book> searchBooks(@RequestParam("query") String query){
        return bookServices.findBookByName(query);
    }
}

