package com.project.auctions.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OfferDtoToAddOffer {
    private Long id;
    private BigDecimal offerPrice;
    private LocalDate dataOfferCreated;
    private LocalDate dataOfferDue;
    private boolean isSold;

    private Long productId;
}
