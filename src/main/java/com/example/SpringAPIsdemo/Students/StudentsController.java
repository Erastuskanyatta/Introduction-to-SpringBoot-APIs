package com.example.SpringAPIsdemo.Students;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping
    public void registerNewStudent(@RequestBody Students students){
        studentsService.addNewStudent(students);
    }
    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long id){
        studentsService.deleteStudent(id);
    }
    @PutMapping
    public @ResponseBody void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String name){
                studentsService.updateStudents(studentId,name);
    }
}
