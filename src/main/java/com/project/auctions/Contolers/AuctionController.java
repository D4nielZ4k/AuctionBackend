package com.project.auctions.Contolers;

import com.project.auctions.dto.AuctionDto;
import com.project.auctions.mappers.AuctionMapper;
import com.project.auctions.service.AuctionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/auction")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AuctionController {

    @Autowired
    AuctionService auctionService;

    private final AuctionMapper auctionMapper;

    @PostMapping(value = "/addAuction")
    public void addAuction(AuctionDto auctionDto) {
        auctionService.addAuction(auctionMapper.mapToAuction(auctionDto));

    }

    @GetMapping(value = "/getAuctionsByOfferId{offerId}")
    public List<AuctionDto> getAuctionsByOfferId(@PathVariable Long offerId) {
        return auctionMapper.mapToAuctionDtoList(auctionService.getAuctionsByOfferId(offerId));
    }


    @GetMapping(value = "/getAuctionsByBidderId{appUserId}")
    public List<AuctionDto> getAuctionsByBidderId(@PathVariable Long appUserId) {
        return auctionMapper.mapToAuctionDtoList(auctionService.getAuctionsByBidderId(appUserId));
    }


    @GetMapping(value = "/getBiggestAuctionByOfferId{offerId}")
    public AuctionDto getBiggestAuctionByOfferId(@PathVariable Long offerId) {
     return auctionMapper.mapToAuctionDto(auctionService.getBiggestAuctionByOfferId(offerId));
    }

    @DeleteMapping(value = "/deleteAuction{auctionId}")
    public void deleteAuction(@PathVariable Long auctionId) {
        auctionService.deleteAuction(auctionId);
    }
}
