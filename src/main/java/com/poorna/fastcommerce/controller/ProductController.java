package com.poorna.fastcommerce.controller;

import com.poorna.fastcommerce.model.Product;
import com.poorna.fastcommerce.payload.ProductDTO;
import com.poorna.fastcommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/admin/categories/{categoryId}/product")
    public ResponseEntity<ProductDTO> addProduct(@RequestBody Product product, @PathVariable Long categoryId) {

        ProductDTO productDTO = productService.addProduct(categoryId,product);
        return new ResponseEntity<>(productDTO, HttpStatus.CREATED);
    }
}
