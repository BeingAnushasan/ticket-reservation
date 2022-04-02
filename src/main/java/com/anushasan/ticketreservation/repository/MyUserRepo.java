package com.anushasan.ticketreservation.repository;

import com.anushasan.ticketreservation.model.User.MyUserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MyUserRepo extends JpaRepository<MyUserDetails, String> {

    MyUserDetails findByUsername(String s);

    Optional<MyUserDetails> findByFullName(String st);
}
