package com.project.auctions.service;

import com.project.auctions.domain.Product;
import com.project.auctions.repository.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RequiredArgsConstructor
@org.springframework.stereotype.Service
public class ProductService {

    @Autowired
    private final ProductRepo productRepo;

    public void saveProduct(final Product product) {
        productRepo.save(product);
    }

    public List<Product> getAllPictures() {
        return productRepo.findAll();
    }

    public Product getProduct(final Long id) {
        return productRepo.findAllById(id);
    }
}
