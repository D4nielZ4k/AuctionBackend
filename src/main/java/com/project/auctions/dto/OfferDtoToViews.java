package com.project.auctions.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class OfferDtoToViews {


    private Long id;
    private String name;
    private String author;
    private int yearOfProduction;
    private String description;
    private String url;
    private BigDecimal offerPrice;
    private Date dataOfferCreated;
    private Date dataOfferDue;
    private boolean isSold;
    private Long sellerId;

    List<AuctionDto> auction;
}
