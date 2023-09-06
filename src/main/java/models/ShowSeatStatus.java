package models;

public enum ShowSeatStatus {
    BOOKED,
    AVAILABLE,
    BLOCKED, // Refers to the seat for which some user is on the payment.
}
