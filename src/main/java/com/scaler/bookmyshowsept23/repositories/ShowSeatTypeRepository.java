package com.scaler.bookmyshowsept23.repositories;

import com.scaler.bookmyshowsept23.models.ShowSeatType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShowSeatTypeRepository extends JpaRepository<ShowSeatType, Long> {
    List<ShowSeatType> findAllByShow(Long showId);
}
