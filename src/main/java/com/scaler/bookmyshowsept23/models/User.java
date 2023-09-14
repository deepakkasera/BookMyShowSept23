package com.scaler.bookmyshowsept23.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class User extends BaseModel {
    private String username;

    private String email;

    private String password;

    @OneToMany
    private List<Booking> bookings;
}

/*

  1  ->    M
User ---- Booking ==> 1:M
 1    <-       1
 */
