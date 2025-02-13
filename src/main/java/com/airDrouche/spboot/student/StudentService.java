package com.airDrouche.spboot.student;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StudentService {

    public List<Student> findAllStudents(){
    return List.of(
            new Student("Riri","titi",LocalDate.now(),"riri@gmail.com",33),
            new Student("fifi","titi", LocalDate.now(),"fifi@gmail.com",33),
            new Student("mimi","titi", LocalDate.now(),"mimi@gmail.com",33),
            new Student("kiki","titi", LocalDate.now(),"kiki@gmail.com",33)
            );
    }
}
