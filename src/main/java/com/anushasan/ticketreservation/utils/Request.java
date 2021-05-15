package com.anushasan.ticketreservation.utils;

import com.anushasan.ticketreservation.model.PaymentInfo;
import com.anushasan.ticketreservation.model.TicketInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Request {
    private TicketInfo ticketInfo;
    private PaymentInfo paymentInfo;
}
