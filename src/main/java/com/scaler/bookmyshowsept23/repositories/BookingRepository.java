package com.scaler.bookmyshowsept23.repositories;

import com.scaler.bookmyshowsept23.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    @Override
    Booking save(Booking booking);
}
