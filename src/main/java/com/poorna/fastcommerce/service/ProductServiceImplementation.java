package com.poorna.fastcommerce.service;

import com.poorna.fastcommerce.exceptionhandling.customexceptions.ResourceNotFoundException;
import com.poorna.fastcommerce.model.Category;
import com.poorna.fastcommerce.model.Product;
import com.poorna.fastcommerce.payload.ProductDTO;
import com.poorna.fastcommerce.payload.ProductResponse;
import com.poorna.fastcommerce.repository.CategoryRepository;
import com.poorna.fastcommerce.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImplementation implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ProductDTO addProduct(Long categoryId, Product product) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(()->
                new ResourceNotFoundException("Category "+categoryId+" not found"));
        product.setCategory(category);
        product.setImage("default.png");
        double specialPrice =product.getPrice()- (product.getDiscount()*0.01)*product.getPrice();
        product.setSpecialPrice(specialPrice);
        Product savedProduct = productRepository.save(product);
        return modelMapper.map(savedProduct, ProductDTO.class);
    }
}
