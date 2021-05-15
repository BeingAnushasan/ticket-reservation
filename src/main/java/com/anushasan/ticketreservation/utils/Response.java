package com.anushasan.ticketreservation.utils;

import com.anushasan.ticketreservation.model.TicketInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {
    private String status;
    //    private double total;
    private TicketInfo ticketInfo;

}
