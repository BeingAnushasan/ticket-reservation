package com.anushasan.ticketreservation.controller;

import com.anushasan.ticketreservation.model.User.MyUserDetails;
import com.anushasan.ticketreservation.repository.MyUserRepo;
import com.anushasan.ticketreservation.service.ReservationService;
import com.anushasan.ticketreservation.utils.Request;
import com.anushasan.ticketreservation.utils.Response;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@RestController
public class ReservationController {

    private final ReservationService reservationService;
    private final MyUserRepo userRepo;

    @PostMapping("/api/v1/reserve")
    public Response reserve(@RequestBody Request request, Principal principal) {
        System.out.println("The request is: ");
        System.out.println(request);
        return reservationService.ReservationAcknowledgement(request, principal);
    }

    @GetMapping("/all")
    public List<MyUserDetails> getAll() {
        return userRepo.findAll();
    }

    @GetMapping("/byday")
    public Map<String, Integer> getPaymentsByDay(){
        return reservationService.getPaymentsByDay();
    }

}
