package com.project.auctions.domain;

import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.NotFound;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "USER")
public class AppUser {

    @Id
    @NotNull
    @GeneratedValue
    private Long id;
    private String userName;
    private String password;
    private String role;

}
