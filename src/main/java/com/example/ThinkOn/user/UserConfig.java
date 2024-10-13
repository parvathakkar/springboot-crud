package com.example.ThinkOn.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {
    @Bean //delcaring a bean
    CommandLineRunner commandLineRunner(UserRepository userRepository) {
        return args -> {
            User me = new User("parvathakkar", "parva","thakkar","something@something.com","12345");
            User other = new User("joshuaT", "josh","chalk","somethingjosh@something.com","12335");
            userRepository.saveAll(List.of(me,other)); //saving the users as a list of users
            //hibernate runs when save all is invoked
        };
    }
}
