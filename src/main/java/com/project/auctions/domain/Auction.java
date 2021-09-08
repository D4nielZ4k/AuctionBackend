package com.project.auctions.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "AUCTIONS")
public class Auction {

    @Id
    @GeneratedValue
    private Long id;
    private BigDecimal price;
    private Date timeCreate;


    @ManyToOne()
    private Offer offer;

    @ManyToOne()
    private AppUser bidder;

}
