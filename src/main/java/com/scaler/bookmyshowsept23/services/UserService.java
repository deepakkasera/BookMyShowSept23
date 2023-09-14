package com.scaler.bookmyshowsept23.services;

import com.scaler.bookmyshowsept23.models.User;
import com.scaler.bookmyshowsept23.repositories.UserRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Getter
@Setter
@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User login(String email, String password) {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if (optionalUser.isEmpty()) {
            throw new RuntimeException("Email isn't present in the DB.");
        }

        User user = optionalUser.get();
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        if (bCryptPasswordEncoder.matches(password, user.getPassword())) {
            //Login successful
            return user;
        }
        throw new RuntimeException("Password mismatch");
    }

    public User signUp(String email, String password) {
        Optional<User> optionalUser = userRepository.findByEmail(email);

        if (optionalUser.isPresent()) {
            return login(email, password);
        }

        User user = new User();
        user.setEmail(email);

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        user.setPassword(bCryptPasswordEncoder.encode(password));
        user.setUsername("");
        user.setBookings(new ArrayList<>());

        User savedUser = userRepository.save(user);
        return savedUser;
    }
}

/*

Scaler

praveen@gmail.com -> password

Scaler DB : "password".
if DB leak happens, then it can lead to HUGE problems.

Password should be encrypted before storing it to the DB.

a->16, b->18, ...

Praveen's : "password" -> 364783674816
Deepak's : "password" -> 364783674816

hacker -> Scaler123, password, name, college

"BCrypt"

 */
