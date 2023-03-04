package com.gmontinny.exemplo.service;


import com.gmontinny.exemplo.model.Product;
import com.gmontinny.exemplo.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SpringDataProductServiceImpl implements SpringDataProductService {

    private final ProductRepository productRepository;

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Optional<Product> getProduct(String id) {
        return productRepository.findById(id);
    }

    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }

    public Iterable<Product> insertBulk(List<Product> products) {
        return productRepository.saveAll(products);
    }

    public List<Product> getProductsByName(String name) {
        return productRepository.findAllByName(name);
    }

    public List<Product> getProductsByNameUsingAnnotation(String name) {
        return productRepository.findAllByNameUsingAnnotations(name);
    }

}
