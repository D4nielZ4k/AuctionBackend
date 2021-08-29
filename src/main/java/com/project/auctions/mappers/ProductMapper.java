package com.project.auctions.mappers;

import com.project.auctions.domain.Product;
import com.project.auctions.dto.ProductDto;
import com.project.auctions.repository.AppUserRepo;
import com.project.auctions.repository.OfferRepo;
import com.project.auctions.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductMapper {

    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private AppUserRepo appUserRepo;
    @Autowired
    private OfferRepo offerRepo;

    public Product mapToProduct(final ProductDto productDto) {
        return new Product(
                productDto.getId(),
                productDto.getName(),
                productDto.getAuthor(),
                productDto.getDateCreated(),
                productDto.getUrl(),
                appUserRepo.getById(productDto.getSellerId())
        );
    }

    public ProductDto mapToProductDto(final Product product) {
        return new ProductDto(
                product.getId(),
                product.getName(),
                product.getAuthor(),
                product.getDateCreated(),
                product.getUrl(),
                product.getSeller().getId()
        );
    }

    public List<ProductDto> mapToProductDtoList(final List<Product> productList) {
        return productList.stream()
                .map(this::mapToProductDto)
                .collect(Collectors.toList());
    }
}
