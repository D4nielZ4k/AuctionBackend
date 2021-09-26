package com.project.auctions.service;

import com.project.auctions.domain.AppUser;
import com.project.auctions.repository.AppUserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AppUserService {

    @Autowired
    private AppUserRepo appUserRepo;

    @Autowired
    private  PasswordEncoder passwordEncoder;


    public void addUser(final AppUser appUser) {
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        appUser.setRole("ROLE_USER");
        appUserRepo.save(appUser);
    }

    public void addAdmin(final AppUser appUser) {
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        appUser.setRole("ROLE_ADMIN");
        appUserRepo.save(appUser);
    }

    public AppUser getUser(Long id) {
        return appUserRepo.getById(id);
    }

    public List<AppUser> getUsers() {
        return appUserRepo.findAll();
    }



    public void deleteUser(final Long id) {
        appUserRepo.deleteById(id);
    }

    public void ChangeRole(final Long appUserId, final String role) {
        appUserRepo.findById(appUserId).orElseThrow().setRole(role);
    }

}
