package models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ShowSeat extends BaseModel{
    @ManyToOne
    private Show show;

    @ManyToOne
    private Seat seat;

    @Enumerated(EnumType.ORDINAL)
    private ShowSeatStatus showSeatStatus;
}

/*

    1    -->    1
ShowSeat ----- Show => M:1
    M    <--     1

    1    -->    1
ShowSeat ----- Seat => M:1
    M    <--     1


    ShowSeat -> <123, A11>
                <123, A12>
                <123, D1>
                <1, D1>
                <124, A11>
                <1234, A11>

 */