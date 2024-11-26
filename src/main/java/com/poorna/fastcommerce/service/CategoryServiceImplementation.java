package com.poorna.fastcommerce.service;

import com.poorna.fastcommerce.model.Category;
import com.poorna.fastcommerce.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImplementation implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public ResponseEntity<List<Category>> getAllCategories() {
        return new ResponseEntity<>(categoryRepository.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> createCategory(Category category) {
        return new ResponseEntity<>(categoryRepository.save(category) + "added", HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<String> deleteCategory(Long id) {

        Category category = categoryRepository.findById(id).orElse(null);
        if (category == null)
        {
            return new ResponseEntity<>("Category not found", HttpStatus.NOT_FOUND);
        }
        categoryRepository.delete(category);
        return new ResponseEntity<>(category.toString() + "removed", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> updateCategory(Long id, Category category) {

        Category existingCategory = categoryRepository.findById(id).orElse(null);

        if (existingCategory == null)
        {
            return new ResponseEntity<>("Category not found", HttpStatus.NOT_FOUND);
        }

        existingCategory.setCategoryName(category.getCategoryName());
        return new ResponseEntity<>(categoryRepository.save(existingCategory) + "updated", HttpStatus.OK);
    }


}
