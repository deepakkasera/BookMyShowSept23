package com.scaler.bookmyshowsept23.controllers;

import com.scaler.bookmyshowsept23.dto.BookMovieRequestDto;
import com.scaler.bookmyshowsept23.dto.BookMovieResponseDto;
import com.scaler.bookmyshowsept23.models.Booking;
import com.scaler.bookmyshowsept23.models.ResponseStatus;
import com.scaler.bookmyshowsept23.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookingController { //Waiter.
    private BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    public BookMovieResponseDto bookMovie(BookMovieRequestDto bookMovieRequestDto) {
        BookMovieResponseDto response = new BookMovieResponseDto();

        try {
            Booking booking = bookingService.bookMovie(bookMovieRequestDto.getUserId(),
                    bookMovieRequestDto.getShowId(),
                    bookMovieRequestDto.getShowSeatIds());

            response.setBookingId(booking.getId());
            response.setResponseStatus(ResponseStatus.SUCCESS);
            response.setAmount(booking.getAmount());
        } catch (RuntimeException runtimeException) {
            response.setResponseStatus(ResponseStatus.FAILURE);
        }

        return response;
    }

    public Booking cancelMovie() {
        return null;
    }
}
