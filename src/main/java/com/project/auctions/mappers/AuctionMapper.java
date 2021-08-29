package com.project.auctions.mappers;

import com.project.auctions.domain.Auction;
import com.project.auctions.dto.AuctionDto;
import com.project.auctions.repository.AppUserRepo;
import com.project.auctions.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuctionMapper {
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private AppUserRepo appUserRepo;
    @Autowired
    private ProductMapper productMapper;

    public AuctionDto mapToAuctionDto(final Auction auction){
        return new AuctionDto();
    }

    public Auction mapToAuction(final AuctionDto auction){
        return new Auction();
    }
}
