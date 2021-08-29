package com.project.auctions.Contolers;

import com.project.auctions.dto.OfferDto;
import com.project.auctions.dto.OfferDtoToAddOffer;
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

  // @GetMapping("/getAllOffersByProductId/{productId}")
  // public List<OfferDto> getAllOffersByProductId(@PathVariable Long productId) {
  //     return offerMapper.mapToOfferDtoList(offerService.getAllOffersByProductId(productId));
  // }

    //  @GetMapping("/getAllOffersBYUserId/{userId}")
    //  public List<OfferDto> getAllOffersBYUserId(@PathVariable Long userId) {
    //      return offerMapper.mapToOfferDtoList(offerService.getAllOffersBYUserId(userId));
    //  }

    @PostMapping("/addOffer")
    public void addOffer(@RequestBody OfferDtoToAddOffer offerDtoToAddOffer) {

        offerService.addOffer(offerMapper.mapToOffer(
                offerMapper.mapToOfferDtoFormOfferDtoToAddOffer(offerDtoToAddOffer)));
    }


    @DeleteMapping("/DeleteMapping{offerId}")
    public void deleteMapping(@PathVariable Long offerId) {
        offerService.deleteOffer(offerId);
    }

}
