package com.project.auctions.mappers;

import com.project.auctions.domain.Offer;
import com.project.auctions.dto.OfferDto;
import com.project.auctions.repository.AppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfferMapper {

    @Autowired
    private AppUserRepo appUserRepo;

    public OfferDto mapToOfferDto(final Offer offer) {
        return new OfferDto(
                offer.getId(),
                offer.getName(),
                offer.getAuthor(),
                offer.getYearOfProduction(),
                offer.getDescription(),
                offer.getUrl(),
                offer.getOfferPrice(),
                offer.getDataOfferCreated(),
                offer.getDataOfferDue(),
                offer.isSold(),
                offer.getSeller().getId()
        );
    }

    //zmien te nazwy zjebie wkoncu
    public Offer mapToOffer(final OfferDto offerDto) {
        return new Offer(
                offerDto.getId(),
                offerDto.getName(),
                offerDto.getAuthor(),
                offerDto.getYearOfProduction(),
                offerDto.getDescription(),
                offerDto.getUrl(),
                offerDto.getOfferPrice(),
                offerDto.getDataOfferCreated(),
                offerDto.getDataOfferDue(),
                offerDto.isSold(),
                appUserRepo.getById(offerDto.getSellerId())
        );
    }

    public List<OfferDto> mapToOfferDtoList(final List<Offer> offerList) {
        return offerList.stream()
                .map(this::mapToOfferDto)
                .collect(Collectors.toList());
    }
}
