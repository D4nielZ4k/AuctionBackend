package com.project.auctions.Contolers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/auction")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AuctionController {



    public void  addAuction(){

    }

    public void  getAuctionById(){

    }

    public void  getAuctionsByOfferId(){

    }
    public void  getAuctionsByBidderId(){

    }

    public void getAuctions(){

    }

    public void deleteAuction(){

    }
}
