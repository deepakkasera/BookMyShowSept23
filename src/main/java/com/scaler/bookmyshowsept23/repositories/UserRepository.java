package com.scaler.bookmyshowsept23.repositories;

import com.scaler.bookmyshowsept23.models.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.function.Function;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    //JPARepository -> Inbuilt support for all type of SQL queries.
    @Override
    Optional<User> findById(Long aLong);

    @Override
    User save(User user);

    Optional<User> findByEmail(String email);
    //select * from users where email = <input_email>

    Optional<User> findByUsername(String userName);
    //select * from users where username = <input>
}
