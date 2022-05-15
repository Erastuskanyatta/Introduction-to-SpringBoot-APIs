package com.example.SpringAPIsdemo.Students;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
@RestController
@RequestMapping("/API/v1/student")
public class StudentsController {
    private final  StudentsService studentsService;

    @Autowired
    public StudentsController(StudentsService studentsService) {
        this.studentsService = studentsService;

    }

    @GetMapping
    public List<Students> GetStudent(){

        return studentsService.GetStudent();
    }
}
