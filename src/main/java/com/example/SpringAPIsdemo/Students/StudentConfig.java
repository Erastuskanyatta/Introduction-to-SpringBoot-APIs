package com.example.SpringAPIsdemo.Students;


import org.aspectj.apache.bcel.Repository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.CommandLinePropertySource;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
        return args -> {
            Students Erastus =new Students(
                    "Erastus",
                    "eras@gmail.com",
                    LocalDate.of(1990, Month.MARCH,21)
            );
            Students Peter =new Students(
                    "Peter",
                    "peter23@gmail.com",
                    LocalDate.of(1998, Month.JUNE,05)
            );
            Students James =new Students(
                    "James",
                    "jameskairu@gmail.com",
                    LocalDate.of(2000, Month.DECEMBER,13)
            );
            Students Elius =new Students(
                    "Elius",
                    "eliuskairu@gmail.com",
                    LocalDate.of(1994, Month.AUGUST,28)
            );
            studentRepository.saveAll(
                    List.of(
                            Erastus,
                            Peter,
                            James,
                            Elius
                    )
            );
        };
    }
}
