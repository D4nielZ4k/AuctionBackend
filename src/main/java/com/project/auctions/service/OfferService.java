package com.project.auctions.service;


import com.project.auctions.domain.Offer;
import com.project.auctions.repository.OfferRepo;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class OfferService {

    @Autowired
    OfferRepo offerRepo;


    public List<Offer> GetOffers(){
      return (List<Offer>) offerRepo.findAll();
    }


    public void addOffer(final Offer offer){
        offer.setDataOfferCreated(LocalDate.now());
        offer.setDataOfferDue(offer.getDataOfferCreated().plusWeeks(2));
        offerRepo.save(offer);
    }

    //Zmienic tak aby zapytanie do serwera filtrowalo dane

    public List<Offer> getAllOffersByProductId(final Long pictureId){
        List<Offer> offerList = (List<Offer>) offerRepo.findAll();
        return offerList.stream().filter(n-> n.getProduct().getId().equals(pictureId))
                .collect(Collectors.toList());
    }
//  public List<Offer> getAllOffersBYUserId(final Long userId){
//      List<Offer> offerList = (List<Offer>) offerRepo.findAll();
//      return offerList.stream()
//              .filter(c-> c.getSeller().getId().equals(userId))
//              .collect(Collectors.toList());
//
//     return offerList.stream().filter(n-> n.getUser().getId().equals(userId))
//             .collect(Collectors.toList());
//  }

    public void deleteOffer(final Long offerId){
        offerRepo.deleteById(offerId);
    }
}
