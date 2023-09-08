package models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Booking extends BaseModel { //Ticket.
    @ManyToMany
    private List<ShowSeat> showSeats;

    @ManyToOne
    private User user;

    private double amount;

    @OneToMany
    List<Payment> payments;

    @Enumerated(EnumType.ORDINAL)
    private BookingStatus bookingStatus;
}

/*
       1   ->    M
   Booking --- ShowSeat => M:M
       M    <-   1


       1    ->   1
   Booking  --- User => M:1
       M     <-     1

       1   ->   M
   Booking -- Payment
       1   <-     1
 */
