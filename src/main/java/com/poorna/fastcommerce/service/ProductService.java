package com.poorna.fastcommerce.service;

import com.poorna.fastcommerce.model.Product;
import com.poorna.fastcommerce.payload.ProductDTO;

public interface ProductService {
    ProductDTO addProduct(Long categoryId, Product product);
}
