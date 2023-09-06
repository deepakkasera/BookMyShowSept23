package models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Booking extends BaseModel { //Ticket.
    private List<ShowSeat> showSeats;
    private User user;
    private double amount;
    List<Payment> payments;
    private BookingStatus bookingStatus;
}
