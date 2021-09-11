package com.project.auctions.Contolers;

import com.project.auctions.dto.CurrencyDto;
import com.project.auctions.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.MalformedURLException;

@RestController
@RequestMapping("/v1/currency")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class CurrencyController {

    @Autowired
    CurrencyService currencyService;

    @GetMapping()
    public CurrencyDto getCurrency() throws IOException, InterruptedException {
        return currencyService.getCurrencyByDto();
    }
}
