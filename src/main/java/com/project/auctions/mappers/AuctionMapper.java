package com.project.auctions.mappers;

import com.project.auctions.domain.Auction;
import com.project.auctions.dto.AuctionDto;
import com.project.auctions.repository.AppUserRepo;
import com.project.auctions.repository.OfferRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuctionMapper {

    @Autowired
    private AppUserRepo appUserRepo;

    @Autowired
    private OfferRepo offerRepo;

    public AuctionDto mapToAuctionDto(final Auction auction) {
        return new AuctionDto(
                auction.getId(),
                auction.getPrice(),
                auction.getTimeCreate(),
                auction.getBidder().getId(),
                auction.getBidder().getId()
        );
    }

    public Auction mapToAuction(final AuctionDto auctionDto) {
        return new Auction(
                auctionDto.getId(),
                auctionDto.getPrice(),
                auctionDto.getTime(),
                offerRepo.findById(auctionDto.getOfferId()).orElseThrow(),
                appUserRepo.findById(auctionDto.getBidderId()).orElseThrow()
        );
    }

    public List<AuctionDto> mapToAuctionDtoList(final List<Auction> auctionList) {
        return auctionList.stream()
                .map(this::mapToAuctionDto)
                .collect(Collectors.toList());
    }
}
