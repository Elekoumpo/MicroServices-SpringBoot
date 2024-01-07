package com.ejubmicro.productservice.service;

import com.ejubmicro.productservice.dto.ProductRequest;
import com.ejubmicro.productservice.model.Product;
import com.ejubmicro.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service //as this is service I added this annotation
@RequiredArgsConstructor  //when I add this annotation I don't have to hold constructor written inside of a class
@Slf4j //for logging
public class ProductService {

    private final ProductRepository productRepository;

    public void createProduct(ProductRequest productRequest){

        //creation of an object of Product class
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();

        //saving created product inside of a database
        productRepository.save(product);
        log.info("Product {} is saved", product.getId());
    }
}
