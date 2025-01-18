package com.poorna.fastcommerce.service;

import com.poorna.fastcommerce.model.Product;
import com.poorna.fastcommerce.payload.ProductDTO;
import com.poorna.fastcommerce.payload.ProductResponse;

public interface ProductService {
    ProductDTO addProduct(Long categoryId, Product product);

    ProductResponse getAllProducts();

    ProductResponse searchByCategory(Long categoryId);

    ProductResponse searchProductByKeyword(String keyword);

    ProductDTO updateProduct(Long productId, Product product);
}
