package com.project.auctions.dto;

import com.project.auctions.domain.AppUser;
import com.project.auctions.domain.Offer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuctionDto {


    private Long id ;
    private BigDecimal price;
    private LocalDate time;

    private Long offerId;

    private Long bidderId;

}
