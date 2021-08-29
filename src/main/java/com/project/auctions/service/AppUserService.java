package com.project.auctions.service;

import com.project.auctions.domain.AppUser;
import com.project.auctions.repository.AppUserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AppUserService {

    @Autowired
    AppUserRepo appUserRepo;

    public AppUser getUser(Long id) {
        return appUserRepo.getById(id);
    }

    public List<AppUser> getUsers() {
        return appUserRepo.findAll();
    }

    public void addUser(final AppUser appUser) {
        appUserRepo.save(appUser);
    }

    public void deleteUser(final Long id) {
        appUserRepo.deleteById(id);
    }

    public void ChangeRole(final Long appUserId,final String role) {
        appUserRepo.findById(appUserId).orElseThrow().setRole(role);
    }

}
