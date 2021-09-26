package com.project.auctions.service;


import com.project.auctions.domain.Offer;
import com.project.auctions.repository.OfferRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@Service
public class OfferService {

    @Autowired
    OfferRepo offerRepo;


    public List<Offer> GetOffers() {
        return (List<Offer>) offerRepo.findAll();
    }

    public void addOffer(Offer offer) {
        offer.setDataOfferCreated(new Date(System.currentTimeMillis()));
        offerRepo.save(offer);
    }

    public void deleteOffer(final Long offerId) {
        offerRepo.deleteById(offerId);
    }


    public List<Offer> getOffersByUser(Long userId) {
        return offerRepo.findOfferByUserId(userId);
    }

}
