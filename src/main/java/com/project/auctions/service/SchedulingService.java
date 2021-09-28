package com.project.auctions.service;

import com.project.auctions.domain.AppUser;
import com.project.auctions.domain.Offer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class SchedulingService {

    @Autowired
    AppUserService appUserService;
    @Autowired
    OfferService offerService;

    @Autowired
    MailService mailService;


    @Scheduled(fixedDelay = 7)
    public void sendMailsWithOffers() throws MessagingException {

        List<Offer> newOffers = offerService.getNewOffers();
        List<String> offers = newOffers.stream()
                .map(Offer::getName)
                .collect(Collectors.toList());


        String text = "najnowsze oferty ktore warto przejrzec to " + offers;
        List<AppUser> users = appUserService.getUsers();
        for (int i = 0; i < users.size(); i++) {
            AppUser appUser = users.get(i);
            mailService.sendMail(
                    "HewnDevil@Gmail.com",
                    appUser.getUsername() + " we have new offers for you",
                    text, false

            );

        }

    }

}
