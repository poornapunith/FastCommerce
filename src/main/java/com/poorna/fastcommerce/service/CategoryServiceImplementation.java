package com.poorna.fastcommerce.service;

import com.poorna.fastcommerce.exceptionhandling.customexceptions.EmptyListException;
import com.poorna.fastcommerce.exceptionhandling.customexceptions.ResourceNotFoundException;
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
        List<Category> categories = categoryRepository.findAll();
        if (categories.isEmpty()) {
            throw new EmptyListException("No categories found");
        }
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> createCategory(Category category) {
        return new ResponseEntity<>(categoryRepository.save(category) + "added", HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<String> deleteCategory(Long id) {

        Category category = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category with id : "+id+" not found"));
        categoryRepository.delete(category);
        return new ResponseEntity<>(category.toString() + "removed", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> updateCategory(Long id, Category category) {

        Category existingCategory = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category with id : "+id+" not found"));

        existingCategory.setCategoryName(category.getCategoryName());
        return new ResponseEntity<>(categoryRepository.save(existingCategory) + "updated", HttpStatus.OK);
    }


}
