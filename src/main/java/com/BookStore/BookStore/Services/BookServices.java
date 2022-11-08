package com.BookStore.BookStore.Services;

import com.BookStore.BookStore.Models.Book;
import com.BookStore.BookStore.Repositories.BookRepository;
import com.BookStore.BookStore.Repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class BookServices {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public void createBook(Long categoryId, Book book){
        categoryRepository.findById(categoryId).map(category ->{
            book.setCategory(category);
            return bookRepository.save(book);
        });
    }
    public ResponseEntity<?> getBookById(Long bookId){
       Book book = bookRepository.findById(bookId).orElse(null);
               return new ResponseEntity<>(book, HttpStatus.OK);
    }
    public Iterable<Book> getAllBooks(){
        return bookRepository.findAll();
    }
    public void updateBookById(Long categoryId, Book book) {
        categoryRepository.findById(categoryId).map(category -> {
            book.setCategory(category);
            return bookRepository.save(book);
        });
    }
    public void deleteBookById(Long bookId){

        bookRepository.deleteById(bookId);
    }
    public Iterable<Book> findByCategoryId(Long categoryId){
        return bookRepository.findByCategoryId(categoryId);
    }
    public Iterable<Book> findBookByName(String query){
        return bookRepository.searchBooks(query);
    }

}
