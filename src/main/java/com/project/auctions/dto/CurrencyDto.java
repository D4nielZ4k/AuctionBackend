package com.project.auctions.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CurrencyDto {

   private String plnUsd;
   private String plnEur;
   private String plnSek;
   private String plnChf;

}
