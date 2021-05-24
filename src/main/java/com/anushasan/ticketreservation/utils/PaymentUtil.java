package com.anushasan.ticketreservation.utils;

import com.anushasan.ticketreservation.exception.InsufficientBalanceException;
import com.anushasan.ticketreservation.model.User.MyUserDetails;


public class PaymentUtil {


    public static boolean validateBalance(Double userBalance, Double ticketPrice) {
        if ((ticketPrice > userBalance)) {
            throw new InsufficientBalanceException("Insufficient Balance");
        } else {
            return true;
        }
    }

}
