package com.scaler.bookmyshowsept23.repositories;

import com.scaler.bookmyshowsept23.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    //JPARepository -> Inbuilt support for all type of SQL queries.
    @Override
    Optional<User> findById(Long aLong);

    @Override
    User save(User user);
}
