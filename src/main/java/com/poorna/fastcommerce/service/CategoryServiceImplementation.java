package com.poorna.fastcommerce.service;

import com.poorna.fastcommerce.model.Category;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImplementation implements CategoryService {

    List<Category> categories = new ArrayList<Category>();
    @Override
    public ResponseEntity<List<Category>> getAllCategories() {
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> createCategory(Category category) {
        categories.add(category);
        return new ResponseEntity<>(category.toString() + "added", HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<String> deleteCategory(Long id) {
        Category category = categories.stream()
                .filter(c -> c.getCategoryId()== (id))
                .findFirst().orElse(null);

        if (category == null)
        {
            return new ResponseEntity<>("Category not found", HttpStatus.NOT_FOUND);
        }
        categories.remove(category);
        return new ResponseEntity<>(category.toString() + "removed", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> updateCategory(Long id, Category category) {

        Category existingCategory = categories.stream()
                .filter(c -> c.getCategoryId()==id)
                .findFirst().orElse(null);

        if (existingCategory == null)
        {
            return new ResponseEntity<>("Category not found", HttpStatus.NOT_FOUND);
        }

        existingCategory.setCategoryName(category.getCategoryName());
        return new ResponseEntity<>(category.toString() + "updated", HttpStatus.OK);
    }


}
