package com.poorna.fastcommerce.controller;

import com.poorna.fastcommerce.model.Category;
import com.poorna.fastcommerce.service.CategoryService;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api")
public class CategoryController {

    Logger log = (Logger) LogManager.getLogger(CategoryController.class);

    @Autowired
    CategoryService categoryService;

    @GetMapping("/public/categories")
    public ResponseEntity<List<Category>> getAllCategories()
    {
        log.info("getAllCategories");
        return categoryService.getAllCategories();
    }

    @PostMapping("/public/categories")
    public ResponseEntity<String> createCategory(@Valid @RequestBody Category category)
    {
        log.info("createCategory"+ category);
        return categoryService.createCategory(category);
    }

    @DeleteMapping("/admin/categories/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id)
    {
        log.info("deleteCategory"+ id);
        return categoryService.deleteCategory(id);
    }

    @PutMapping("/public/categories/{id}")
    public ResponseEntity<String> updateCategory(@PathVariable Long id, @RequestBody Category category)
    {
        log.info("updateCategory"+ id);
        return categoryService.updateCategory(id,category);
    }


}
