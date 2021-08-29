package com.project.auctions.repository;

import com.project.auctions.domain.Auction;
import org.springframework.data.repository.CrudRepository;

public interface AuctionRepo extends CrudRepository<Auction, Long> {
}
