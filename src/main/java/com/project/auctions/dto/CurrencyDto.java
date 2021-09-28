package com.project.auctions.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CurrencyDto {

    private String plnUsd;
    private String plnEur;
    private String plnSek;
    private String plnChf;

}
