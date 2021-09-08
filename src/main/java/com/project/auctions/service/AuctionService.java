package com.project.auctions.service;


import com.project.auctions.domain.Auction;
import com.project.auctions.dto.AuctionDto;
import com.project.auctions.repository.AuctionRepo;
import com.project.auctions.repository.OfferRepo;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuctionService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuctionService.class);

    @Autowired
    AuctionRepo auctionRepo;

    @Autowired
    OfferRepo offerRepo;


    //dodanie sprawdzanie czasu
    public void addAuction(final Auction auction) {
     int offerPrice = offerRepo.findById(auction.getOffer().getId()).get().getOfferPrice().intValue();
     Auction auctionFromSql = auctionRepo.findAuctionByHighPrice("" + auction.getOffer().getId());
     if (auctionFromSql == null) {
         auctionFromSql = new Auction();
         auctionFromSql.setPrice(new BigDecimal(-1));
     }

     if (offerPrice < auction.getPrice().intValue()
             && auctionFromSql.getPrice().intValue() < auction.getPrice().intValue()
             &&auction.getTimeCreate().before(offerRepo.findById(auction.getOffer().getId()).get().getDataOfferDue())
     ) {
         auction.setTimeCreate(new Date(System.currentTimeMillis()));
         auctionRepo.save(auction);
         LOGGER.info("The price has been raised");
         System.out.println(auctionFromSql);
     } else {
         LOGGER.info("The price must be higher");
         System.out.println("The price must be higher");
     }
    }


     //posortowac po najwyzszej cenie
    public List<Auction> getAuctionsByOfferId(Long offerId){
        return auctionRepo.findAllByOfferId(offerId.toString());
    }


    public void deleteAuction(Long auctionId){
        auctionRepo.deleteById(auctionId);
    }

    public List<Auction>  getAuctionsByBidderId( Long appUserId){
        return auctionRepo.findAuctionByBidderId(appUserId);
    }

    public Auction getBiggestAuctionByOfferId(Long OfferId) {
        return auctionRepo.findAuctionByHighPrice(OfferId.toString());
    }
}
