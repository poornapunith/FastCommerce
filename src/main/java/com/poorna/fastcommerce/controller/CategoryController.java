package com.poorna.fastcommerce.controller;

import com.poorna.fastcommerce.model.Category;
import com.poorna.fastcommerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/public/categories")
    public ResponseEntity<List<Category>> getAllCategories()
    {
        return categoryService.getAllCategories();
    }

    @PostMapping("/public/categories")
    public ResponseEntity<String> createCategory(@RequestBody Category category)
    {
        return categoryService.createCategory(category);
    }

    @DeleteMapping("/admin/categories/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id)
    {
        return categoryService.deleteCategory(id);
    }

    @PutMapping("/public/categories/{id}")
    public ResponseEntity<String> updateCategory(@PathVariable Long id, @RequestBody Category category)
    {
        return categoryService.updateCategory(id,category);
    }


}
