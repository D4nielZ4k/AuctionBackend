package com.project.auctions.Contolers;

import com.project.auctions.dto.ProductDto;
import com.project.auctions.mappers.ProductMapper;
import com.project.auctions.repository.AppUserRepo;
import com.project.auctions.repository.ProductRepo;
import com.project.auctions.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/product")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    ProductRepo productRepo;

    private final ProductMapper productMapper;

    @Autowired
    private AppUserRepo appUserRepo;

    @Autowired
    private ProductService service;



    @GetMapping(value = "/getProduct{productId}")
    public ProductDto getProduct(@PathVariable Long productId) {
        return productMapper.mapToProductDto(service.getProduct(productId));
    }

    @GetMapping(value = "/getProducts")
    public List<ProductDto> getProducts() {
        return productMapper.mapToProductDtoList(service.getAllPictures());
    }

    @PostMapping(value = "/addProduct")
    public void addProduct(@RequestBody ProductDto productDto) {
        service.saveProduct(productMapper.mapToProduct(productDto));
    }

}
