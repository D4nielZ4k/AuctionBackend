package com.project.auctions.mappers;

import com.project.auctions.domain.AppUser;
import com.project.auctions.dto.AppUserDto;
import com.project.auctions.repository.AppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppUserMapper {

    @Autowired
    private AppUserRepo appUserRepo;

    public AppUserDto mapToAppUserDto (final AppUser appUser){
        return new AppUserDto(
                appUser.getId(),
                appUser.getUsername(),
                appUser.getPassword(),
                appUser.getRole()
        );
    }

    public AppUser mapToAppUser (final AppUserDto appUserDto){
        return new AppUser(
                appUserDto.getId(),
                appUserDto.getUserName(),
                appUserDto.getPassword(),
                appUserDto.getRole()
        );
    }

    public List<AppUserDto> mapToAppUserDtoList(final List<AppUser> appUsers){
        return  appUsers.stream()
                .map(this::mapToAppUserDto)
                .collect(Collectors.toList());
    }
}

