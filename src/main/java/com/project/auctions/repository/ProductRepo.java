package com.project.auctions.repository;

import com.project.auctions.domain.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo  extends CrudRepository<Product,Long> {
    Product findAllById (Long id);

    @Override
    List<Product> findAll();
}
