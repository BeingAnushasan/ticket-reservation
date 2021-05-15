package com.anushasan.ticketreservation.model.User;


import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
public class MyUserDetails {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private String fullName;
    private String phoneNumber;
    private String email;
    private String username;
    private String password;


    private boolean enabled;
    private boolean accountNonExpired;
    private boolean credentialsNonExpired;
    private boolean accountNonLocked;

    private Double balance;

    @ElementCollection(fetch = FetchType.EAGER)
    Set<UserRoles> userRoles = new HashSet<>();

}
