package com.anushasan.ticketreservation.repository;

import com.anushasan.ticketreservation.model.TicketInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TicketRepo extends JpaRepository<TicketInfo, String> {
}
