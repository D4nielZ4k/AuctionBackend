package com.project.auctions.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "OFFERS")
public class Offer {

    @Id
    @GeneratedValue
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


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seller_id")
    private AppUser seller;
}
