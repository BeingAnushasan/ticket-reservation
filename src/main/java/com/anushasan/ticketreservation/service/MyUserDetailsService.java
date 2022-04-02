package com.anushasan.ticketreservation.service;

import com.anushasan.ticketreservation.model.User.MyUserDetails;
import com.anushasan.ticketreservation.model.User.UserPermissions;
import com.anushasan.ticketreservation.model.User.UserRoles;
import com.anushasan.ticketreservation.repository.MyUserRepo;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class MyUserDetailsService implements UserDetailsService {
    PasswordEncoder passwordEncoder;
    MyUserRepo userRepo;

    public MyUserDetailsService(@Lazy PasswordEncoder passwordEncoder, MyUserRepo userRepo) {
        this.passwordEncoder = passwordEncoder;
        this.userRepo = userRepo;
    }

    public MyUserDetails createUser(MyUserDetails user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        MyUserDetails byUsername = userRepo.findByUsername(s);

        List<GrantedAuthority> authorities = new ArrayList<>();
        for (UserRoles userRoles : byUsername.getUserRoles()) {
            Set<UserPermissions> permissions = userRoles.getPermissions();
            authorities.addAll(permissions);
        }

        System.out.println("Roles are :" + authorities);

        return new User(byUsername.getUsername(), byUsername.getPassword(), authorities);
    }


}