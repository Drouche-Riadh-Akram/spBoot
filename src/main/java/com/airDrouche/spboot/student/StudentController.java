package com.airDrouche.spboot.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
//    @Autowired field injection but less suitable
    private final StudentService studentService;
@Autowired //constructeur injection way more suitable : no need to specify @autowired in newer sp versions
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> findAllStudents(){
        return   studentService.findAllStudents();

    }
}
