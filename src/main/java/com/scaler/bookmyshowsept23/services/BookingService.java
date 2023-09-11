package com.scaler.bookmyshowsept23.services;

import com.scaler.bookmyshowsept23.dto.BookMovieResponseDto;
import com.scaler.bookmyshowsept23.exceptions.ShowNotFoundException;
import com.scaler.bookmyshowsept23.exceptions.ShowSeatNotAvailableException;
import com.scaler.bookmyshowsept23.exceptions.UserNotFoundException;
import com.scaler.bookmyshowsept23.models.*;
import com.scaler.bookmyshowsept23.repositories.ShowRepository;
import com.scaler.bookmyshowsept23.repositories.ShowSeatRepository;
import com.scaler.bookmyshowsept23.repositories.UserRepository;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseDataSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService { //@Service //@Controller //@Repository //@Component
    private UserRepository userRepository;
    private ShowRepository showRepository;
    private ShowSeatRepository showSeatRepository;

    public BookingService(UserRepository userRepository,
                          ShowRepository showRepository,
                          ShowSeatRepository showSeatRepository) {
        this.userRepository = userRepository;
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking bookMovie(Long userId, Long showId, List<Long> showSeatIds) {
        /*
            Steps :- (Reference : Approach#1 from notes.)
            -------------TAKE A LOCK----------------
            1. Get the user from userId.
            2. Get the show from showId.
            3. Get the list of showSeats from showSeatIds.
            4. Check if all the show seats are available.
            5. If all the show seats are not available then throw an exception.
            6. If all are available, then change the status to be LOCKED.
            7. Change the status in DB as well.
            8. Create the Booking Object, and store it in DB.
            9. Return the Booking Object.
            -----------RELEASE THE LOCK---------------
         */
        //1. Get the user from userId.
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isEmpty()) {
            throw new UserNotFoundException("Invalid userId");
        }
        User bookedBy = optionalUser.get();

        //2. Get the show from showId.
        Optional<Show> optionalShow = showRepository.findById(showId);
        if (optionalShow.isEmpty()) {
            throw new ShowNotFoundException("Invalid showId");
        }
        Show show = optionalShow.get();

        //3. Get the list of showSeats from showSeatIds.
        List<ShowSeat> showSeats = showSeatRepository.findAllById(showSeatIds);
        //4. Check if all the show seats are available.
        for (ShowSeat showSeat : showSeats) {
            if (!showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE)) {
                //5. If all the show seats are not available then throw an exception.
                throw new ShowSeatNotAvailableException("ShowSeat with id: " + showSeat.getId() + " isn't available.");
            }
        }

        //6. If all are available, then change the status to be LOCKED.
        for (ShowSeat showSeat : showSeats) {
            showSeat.setShowSeatStatus(ShowSeatStatus.LOCKED);
            //7. Change the status in DB as well.

        }

    }
}
