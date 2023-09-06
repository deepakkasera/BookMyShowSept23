package models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class User extends BaseModel {
    private String username;
    private String email;
    private List<Booking> bookings;
}
