package com.example.SpringAPIsdemo.Students;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
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

    public void deleteStudent(Long studentId) {
       boolean exist = studentRepository.existsById(studentId);

       if(!exist){
           throw new IllegalStateException(" User by id "  + studentId + " does Not Exist. Please try another Student");
        }

           studentRepository.deleteById(studentId);
    }
     @Transactional
    public void updateStudents(Long studentId,
                               String name) {
       Students students = studentRepository.findById(studentId)
               .orElseThrow(() -> new IllegalStateException(
                       "student with that id " + studentId + " does not exist!"
               ));
       if (name != null &&
               name.length() > 0 &&
               !Objects.equals(students.getName(), name)){
           students.setName(name);
       }
     }
}

//         if(email !== null &&
//                 email.length() > 0 &&
//                 !Objects.equals(students.getEmail(), email))
//         {
//             Optional<Students> studentsOptional = studentRepository
//                     .findStudentsByEmail(null);
//             if(studentsOptional.isPresent()){
//                 throw new IllegalStateException("email taken. Sorry!");
//             }
//             students.setEmail(null);
//         }

