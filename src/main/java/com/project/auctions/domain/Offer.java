package com.project.auctions.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NotFound;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@lombok.Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Offer {

    @Id
    @NotFound
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal offerPrice;
    private LocalDate dataOfferCreated;
    private LocalDate dataOfferDue;
    private boolean isSold;


    @OneToOne(
            //   cascade = CascadeType.ALL
    )
    private Product product;


}
