package com.poorna.fastcommerce.repository;

import com.poorna.fastcommerce.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
