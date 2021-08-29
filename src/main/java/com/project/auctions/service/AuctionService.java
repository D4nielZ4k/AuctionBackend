package com.project.auctions.service;


import com.project.auctions.repository.AuctionRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuctionService {

    @Autowired
    AuctionRepo auctionRepo;




}
