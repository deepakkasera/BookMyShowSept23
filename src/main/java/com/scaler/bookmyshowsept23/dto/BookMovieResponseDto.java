package com.scaler.bookmyshowsept23.dto;

import com.scaler.bookmyshowsept23.models.ResponseStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookMovieResponseDto {
    private Long bookingId;
    private double amount;
    private ResponseStatus responseStatus;
}
