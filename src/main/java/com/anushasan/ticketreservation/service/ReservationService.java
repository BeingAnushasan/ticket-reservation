package com.anushasan.ticketreservation.service;


import com.anushasan.ticketreservation.model.User.MyUserDetails;
import com.anushasan.ticketreservation.model.PaymentInfo;
import com.anushasan.ticketreservation.model.TicketInfo;
import com.anushasan.ticketreservation.repository.MyUserRepo;
import com.anushasan.ticketreservation.repository.PaymentRepo;
import com.anushasan.ticketreservation.repository.TicketRepo;
import com.anushasan.ticketreservation.utils.PaymentUtil;
import com.anushasan.ticketreservation.utils.Request;
import com.anushasan.ticketreservation.utils.Response;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;

@AllArgsConstructor
@Service
@Transactional
public class ReservationService {

    private final PaymentRepo paymentRepo;
    private final TicketRepo ticketRepo;
    private final MyUserRepo userRepo;


    public Response ReservationAcknowledgement(Request request, Principal principal) {
        TicketInfo ticketInfo = request.getTicketInfo();
        PaymentInfo paymentInfo = request.getPaymentInfo();
        MyUserDetails byUsername = userRepo.findByUsername(principal.getName());

        ticketInfo.setUserDetails(byUsername);
        TicketInfo savedTicketInfo = ticketRepo.save(ticketInfo);


        //Payment Processing
        PaymentUtil.validateBalance(byUsername, ticketInfo.getPrice());
        Double newBalance = byUsername.getBalance() - ticketInfo.getPrice();
        byUsername.setBalance(newBalance);

        userRepo.save(byUsername);

        paymentInfo.setTicketInfo(savedTicketInfo);
        paymentInfo.setAmount(savedTicketInfo.getPrice());
        paymentRepo.save(paymentInfo);

        return new Response("RESERVATION SUCCESSFUL", savedTicketInfo);
    }
}
