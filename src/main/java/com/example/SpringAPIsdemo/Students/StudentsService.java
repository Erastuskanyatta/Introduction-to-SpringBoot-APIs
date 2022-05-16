package com.example.SpringAPIsdemo.Students;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Service
public class StudentsService {
    private  final StudentRepository studentRepository;

    @Autowired
    public StudentsService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Students> GetStudent(){
       return  studentRepository.findAll();
    }

    public void addNewStudent(Students students) {
        Optional<Students> StudentOptional= studentRepository
                .findStudentsByEmail(students.getEmail());
        if(StudentOptional.isPresent()){
            throw new IllegalStateException("Email is already taken");
        }
        studentRepository.save(students);
    }
}
