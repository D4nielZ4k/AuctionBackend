package com.project.auctions.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Setter
public class AuctionDto {


    private Long id;
    private BigDecimal price;
    private Date time;
    private Long offerId;
    private Long bidderId;


}
