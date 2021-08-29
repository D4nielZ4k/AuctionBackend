package com.project.auctions.Contolers;

import com.project.auctions.domain.AppUser;
import com.project.auctions.dto.AppUserDto;
import com.project.auctions.mappers.AppUserMapper;
import com.project.auctions.repository.AppUserRepo;
import com.project.auctions.service.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/appUser")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AppUserController {


    @Autowired
    AppUserService appUserService;
    @Autowired
    AppUserMapper appUserMapper;

    @GetMapping(value = "/getUser{userID}")
    public AppUser getUser(@PathVariable Long userID){
       return appUserService.getUser(userID);
    }
    //Cos sie jebie
    @GetMapping(value = "/getUsers")
    public List<AppUser> getUsers(){
       return appUserService.getUsers();
    }

    @PostMapping("/addUser")
    public void addUser(@RequestBody AppUserDto appUserDto){
       appUserService.addUser(appUserMapper.mapToAppUser(appUserDto));
    }

    @DeleteMapping("/deleteUser{userId}")
    public void deleteUser(@PathVariable Long userId){
        appUserService.deleteUser(userId);
    }

    @PutMapping("/changeRole{userId}{newRole}")
    public void changeRole(@PathVariable Long userId,@PathVariable String newRole){
        appUserService.getUser(userId).setRole(newRole);
    }






    //getUser
    //getusers
    //addUser
    //deleteUser
    //ChangeRole
}
