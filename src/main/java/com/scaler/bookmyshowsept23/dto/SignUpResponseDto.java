package com.scaler.bookmyshowsept23.dto;

import com.scaler.bookmyshowsept23.models.ResponseStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpResponseDto {
    private Long userId;
    private ResponseStatus responseStatus;
}
