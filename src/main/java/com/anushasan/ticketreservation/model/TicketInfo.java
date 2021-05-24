package com.anushasan.ticketreservation.model;

import com.anushasan.ticketreservation.model.User.MyUserDetails;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class TicketInfo {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private String tId;
    private String source;
    private String destination;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date travelDate;
    private String pickupTime;
    private String arrivalTime;
    private Double price;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate reservedDate;

    @ManyToOne
    private MyUserDetails userDetails;

    public TicketInfo() {
    }

    public TicketInfo(String tId, String source, String destination, Date travelDate, String pickupTime, String arrivalTime, Double price, LocalDate reservedDate, MyUserDetails userDetails) {
        this.tId = tId;
        this.source = source;
        this.destination = destination;
        this.travelDate = travelDate;
        this.pickupTime = pickupTime;
        this.arrivalTime = arrivalTime;
        this.price = price;
        this.reservedDate = reservedDate;
        this.userDetails = userDetails;
    }

    public String gettId() {
        return tId;
    }

    public void settId(String tId) {
        this.tId = tId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getTravelDate() {
        return travelDate;
    }

    public void setTravelDate(Date travelDate) {
        this.travelDate = travelDate;
    }

    public String getPickupTime() {
        return pickupTime;
    }

    public void setPickupTime(String pickupTime) {
        this.pickupTime = pickupTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDate getReservedDate() {
        return reservedDate;
    }

    public void setReservedDate(LocalDate reservedDate) {
        this.reservedDate = reservedDate;
    }

    public MyUserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(MyUserDetails userDetails) {
        this.userDetails = userDetails;
    }

    @Override
    public String toString() {
        return "TicketInfo{" +
                "tId='" + tId + '\'' +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", travelDate=" + travelDate +
                ", pickupTime='" + pickupTime + '\'' +
                ", arrivalTime='" + arrivalTime + '\'' +
                ", price=" + price +
                ", reservedDate=" + reservedDate +
                ", userDetails=" + userDetails +
                '}';
    }
}
