package com.anushasan.ticketreservation.utils;

import com.anushasan.ticketreservation.exception.InsufficientBalanceException;
import com.anushasan.ticketreservation.model.User.MyUserDetails;


public class PaymentUtil {


    public static boolean validateBalance(MyUserDetails userDetails, Double ticketPrice) {
        if ((ticketPrice > userDetails.getBalance())) {
            throw new InsufficientBalanceException("Insufficient Balance");
        } else {
            return true;
        }
    }

}
