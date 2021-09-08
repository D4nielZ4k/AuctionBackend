package com.project.auctions.repository;

import com.project.auctions.domain.Auction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuctionRepo extends CrudRepository<Auction, Long> {

    @Query(value = "SELECT * FROM auctions.auction WHERE offer_id= :ARG ORDER BY price DESC LIMIT 1",nativeQuery = true)
    Auction findAuctionByHighPrice(@Param("ARG") String arg);

    @Query(value ="SELECT * FROM auctions.auction WHERE offer_id= :ARG",nativeQuery = true)
    List<Auction>findAllByOfferId(@Param("ARG") String arg);

    @Query(value ="SELECT * FROM auctions.auction WHERE bidder_id= :ARG",nativeQuery = true)
    List<Auction>findAuctionByBidderId(@Param("ARG") Long arg);
}
