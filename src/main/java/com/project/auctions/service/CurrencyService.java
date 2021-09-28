package com.project.auctions.service;

import com.project.auctions.dto.CurrencyDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
@Slf4j
public class CurrencyService {


    protected static final String CURRENCY_URL = "https://currency-exchange.p.rapidapi.com/exchange?to=";

    protected static final String API_KEY = "71287371d4msh696804abe8f0d42p188a50jsna2c07fa92986";
    protected static final String VALUE = "currency-exchange.p.rapidapi.com";

    protected String getCurrency(String value) throws IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://currency-exchange.p.rapidapi.com/exchange?to=PLN&from=" + value + "&q=1.0"))
                .header("x-rapidapi-host", VALUE)
                .header("x-rapidapi-key", API_KEY)
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());

        return response.body();
    }

    public CurrencyDto getCurrencyByDto() throws IOException, InterruptedException {
        return new CurrencyDto(
                getCurrency("USD"), getCurrency("EUR"), getCurrency("SEK"), getCurrency("CHF")
        );
    }

}
