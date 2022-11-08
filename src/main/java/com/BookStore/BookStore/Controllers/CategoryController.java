package com.BookStore.BookStore.Controllers;

import com.BookStore.BookStore.Models.Category;
import com.BookStore.BookStore.Services.CategoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CategoryController {

    @Autowired
    private CategoryServices categoryServices;


    @PostMapping("/category")
    public ResponseEntity<?> createCategory(@RequestBody Category category) {
        return categoryServices.createCategory(category);
    }


    @GetMapping("/category/id")
    public ResponseEntity<?> getCategoryById(@PathVariable Long categoryId) {
        categoryServices.verifyCategory(categoryId);
        return categoryServices.getCategory(categoryId);
    }

    @GetMapping("/category")
    public ResponseEntity<Iterable<Category>> getAllCategory() {
        return categoryServices.getAllCategory();
    }

    @PutMapping("/category/id")
    public ResponseEntity<?> updateCategory(@RequestBody Category category, @PathVariable Long categoryId) {
        categoryServices.verifyCategory(categoryId);
        categoryServices.updateCategory(category, categoryId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/category/id")
    public ResponseEntity<?> deleteCategory(@PathVariable Long categoryId) {
        categoryServices.verifyCategory(categoryId);
        return categoryServices.deleteCategory(categoryId);
    }
}
