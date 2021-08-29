package com.project.auctions;

import com.project.auctions.domain.Offer;
import com.project.auctions.mappers.ProductMapper;
import com.project.auctions.repository.AppUserRepo;
import com.project.auctions.repository.OfferRepo;
import com.project.auctions.repository.ProductRepo;
import com.project.auctions.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@SpringBootTest
public class test {



    @Autowired
    AppUserRepo appUserRepo;
    @Autowired
    ProductRepo productRepo;
    @Autowired
    ProductService serviceDb;
    @Autowired
    ProductMapper productMapper;
    @Autowired
    OfferRepo offerRepo;

    @Test
    void test() {

        Date date = new Date(System.currentTimeMillis());


        System.out.println(date);

    }
}
