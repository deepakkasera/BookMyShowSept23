package com.scaler.bookmyshowsept23.models;

public enum ShowSeatStatus {
    BOOKED,
    AVAILABLE,
    LOCKED, // Refers to the seat for which some user is on the payment.
}
