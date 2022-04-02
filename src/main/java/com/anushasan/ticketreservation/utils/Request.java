package com.anushasan.ticketreservation.utils;

import com.anushasan.ticketreservation.model.PaymentInfo;
import com.anushasan.ticketreservation.model.TicketInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Request {
    private TicketInfo ticketInfo;
    private PaymentInfo paymentInfo;

    public Request() {
    }

    public Request(TicketInfo ticketInfo, PaymentInfo paymentInfo) {
        this.ticketInfo = ticketInfo;
        this.paymentInfo = paymentInfo;
    }

    public TicketInfo getTicketInfo() {
        return ticketInfo;
    }

    public void setTicketInfo(TicketInfo ticketInfo) {
        this.ticketInfo = ticketInfo;
    }

    public PaymentInfo getPaymentInfo() {
        return paymentInfo;
    }

    public void setPaymentInfo(PaymentInfo paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

  
}
