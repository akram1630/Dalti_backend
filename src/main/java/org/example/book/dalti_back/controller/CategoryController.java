package org.example.book.dalti_back.controller;

import org.example.book.dalti_back.entity.Category;
import org.example.book.dalti_back.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService; ////


    @PostMapping("")
    public ResponseEntity<?> insert(@RequestBody Category category) {
        return ResponseEntity.ok(categoryService.insert(category));
    }

    @GetMapping("/{id}")
    public Category findById(@PathVariable Long id) {
        return categoryService.findById(id);
    }

    @GetMapping()
    public List<Category> findAll() {
        return categoryService.findAll();
    }

    @PutMapping()
    public ResponseEntity<?> update(@RequestBody Category category){
        return ResponseEntity.ok(categoryService.update( category));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){ //we can use void
        categoryService.deleteById(id);
        return ResponseEntity.ok(null);
    }

    @GetMapping("/{id}/services")
    public ResponseEntity<?> getServicesByCategoryId(@PathVariable Long id) {
        return ResponseEntity.ok( categoryService.getServicesByCategoryId(id));
    }




}
