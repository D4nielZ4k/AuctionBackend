package com.project.auctions.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OfferDto {

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
}
