package com.project.auctions.dto;

import com.project.auctions.domain.AppUser;
import com.project.auctions.domain.Offer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Setter
public class AuctionDto {


    private Long id ;
    private BigDecimal price;
    private Date time;
    private Long offerId;
    private Long bidderId;


}
