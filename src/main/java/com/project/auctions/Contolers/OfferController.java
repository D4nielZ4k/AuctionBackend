package com.project.auctions.Contolers;

import com.project.auctions.dto.OfferDto;
import com.project.auctions.mappers.OfferMapper;
import com.project.auctions.service.OfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/offer")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class OfferController {

    @Autowired
    OfferService offerService;

    @Autowired
    OfferMapper offerMapper;

    @GetMapping("/getOffers")
    public List<OfferDto> GetOffers() {
        return offerMapper.mapToOfferDtoList(offerService.GetOffers());
    }


    @PostMapping("/addOffer")
    public void addOffer(@RequestBody OfferDto offerDto) {
        offerService.addOffer(offerMapper.mapToOffer(offerDto));
    }


    @DeleteMapping("/DeleteMapping{offerId}")
    public void deleteMapping(@PathVariable Long offerId) {
        offerService.deleteOffer(offerId);
    }


    @GetMapping("/getOffersByUser{userId}")
    public List<OfferDto> getOffersByUser(@PathVariable Long userId) {
        return offerMapper.mapToOfferDtoList(offerService.getOffersByUser(userId));
    }
}
