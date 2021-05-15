package com.anushasan.ticketreservation.repository;

import com.anushasan.ticketreservation.model.PaymentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepo extends JpaRepository<PaymentInfo, String> {
}
