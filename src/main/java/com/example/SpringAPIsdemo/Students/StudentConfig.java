package com.example.SpringAPIsdemo.Students;


import org.aspectj.apache.bcel.Repository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.CommandLinePropertySource;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.util.Calendar.JULY;
import static java.util.Calendar.JUNE;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
        return args -> {
            Students JohnMuriiithi = new Students(
                    "johnMuriithi",
                    "jonmwangi@gmail.com",
                    LocalDate.of(2005, 06, 21)
            );
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
            Students Grace = new Students(
                    "Grace",
                    "gracemurithi@gmail.com",
                    LocalDate.of(1972, JUNE,20)
            );
            Students EricG =new Students(
                    "Eric Gachoki",
                    "ericg@gmail.com",
                    LocalDate.of(2001, JULY,23)
            );
            Students Beatrice = new Students(
                    "Beatrice Wanjiru",
                    "beatrice@gmail.com",
                    LocalDate.of(2010, 12,23)

            );
            studentRepository.saveAll(
                    List.of(
                            Erastus,
                            Peter,
                            James,
                            Elius,
                            Grace,
                            EricG,
                            Beatrice,
                            JohnMuriiithi
                    )
            );
        };
    }
}
