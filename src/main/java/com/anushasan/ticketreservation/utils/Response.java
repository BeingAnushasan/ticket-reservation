package com.anushasan.ticketreservation.utils;

import com.anushasan.ticketreservation.model.TicketInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class Response {
    private String status;
    //    private double total;
    private TicketInfo ticketInfo;

    public Response(String status, TicketInfo ticketInfo) {
        this.status = status;
        this.ticketInfo = ticketInfo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public TicketInfo getTicketInfo() {
        return ticketInfo;
    }

    public void setTicketInfo(TicketInfo ticketInfo) {
        this.ticketInfo = ticketInfo;
    }

    public Response(String status) {
        this.status = status;
    }
}
