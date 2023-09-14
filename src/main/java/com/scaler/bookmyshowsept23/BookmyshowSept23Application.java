package com.scaler.bookmyshowsept23;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BookmyshowSept23Application {
    public static void main(String[] args) {
        SpringApplication.run(BookmyshowSept23Application.class, args);
    }

}
