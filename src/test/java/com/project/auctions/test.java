package com.project.auctions;

import com.project.auctions.repository.AppUserRepo;
import com.project.auctions.repository.OfferRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

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
