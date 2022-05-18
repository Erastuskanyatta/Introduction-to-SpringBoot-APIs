package com.example.SpringAPIsdemo.Students;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository
        extends JpaRepository<Students, Long> {

    Optional<Students> findStudentsByEmail(String email);


}
