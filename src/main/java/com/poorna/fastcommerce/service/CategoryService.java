package com.poorna.fastcommerce.service;

import com.poorna.fastcommerce.model.Category;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


public interface CategoryService {

     ResponseEntity<List<Category>> getAllCategories();
     ResponseEntity<String> createCategory(@RequestBody Category category);
     ResponseEntity<String> deleteCategory(Long id);

     ResponseEntity<String> updateCategory(Long id, Category category);
}
