package com.project.auctions.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Auction {

    @Id
    @GeneratedValue
    private Long id;
    private BigDecimal price;
    private Date timeCreate;

    @ManyToOne
    private Offer offer;

    @ManyToOne
    private AppUser bidder;

}
