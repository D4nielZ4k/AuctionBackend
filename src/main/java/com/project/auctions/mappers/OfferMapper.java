package com.project.auctions.mappers;

import com.project.auctions.domain.Offer;
import com.project.auctions.dto.OfferDto;
import com.project.auctions.dto.OfferDtoToAddOffer;
import com.project.auctions.repository.AppUserRepo;
import com.project.auctions.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfferMapper {
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private AppUserRepo appUserRepo;
    @Autowired
    private ProductMapper productMapper;

    public OfferDto mapToOfferDto(final Offer offer) {
        return new OfferDto(
                offer.getId(),
                offer.getOfferPrice(),
                offer.getDataOfferCreated(),
                offer.getDataOfferDue(),
                offer.isSold(),
                productMapper.mapToProductDto(offer.getProduct())
        );
    }

    //zmien te nazwy zjebie wkoncu
    public Offer mapToOffer(final OfferDto offerDto) {
        return new Offer(
                offerDto.getId(),
                offerDto.getOfferPrice(),
                offerDto.getDataOfferCreated(),
                offerDto.getDataOfferDue(),
                offerDto.isSold(),
                productMapper.mapToProduct(offerDto.getProductDto())
        );
    }

    public OfferDto mapToOfferDtoFormOfferDtoToAddOffer(final OfferDtoToAddOffer offer) {
        return new OfferDto(
                offer.getId(),
                offer.getOfferPrice(),
                offer.getDataOfferCreated(),
                offer.getDataOfferDue(),
                offer.isSold(),
                productMapper.mapToProductDto(productRepo.findById(offer.getProductId()).get())
        );
    }


    public List<OfferDto> mapToOfferDtoList(final List<Offer> offerList) {
        return offerList.stream()
                .map(this::mapToOfferDto)
                .collect(Collectors.toList());
    }
}
