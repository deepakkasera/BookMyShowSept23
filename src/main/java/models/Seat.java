package models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Seat extends BaseModel {
    private String number;
    private SeatType seatType;
    private int row;
    private int col;
}
