package com.airDrouche.spboot.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping
    //@RequestBody to map it from json to pojo
    public Student save(@RequestBody Student student ){
        return studentService.save(student);
    }

    //ask for email as path param /email or @requestParam
    @GetMapping("/{email}")
    public Student findByEmail(@PathVariable("email") String em){
        return studentService.findByEmail(em);
    }
    @PutMapping
    public Student update (@RequestBody Student stu){
        return studentService.update(stu);
    }
    @DeleteMapping("/{email}")
    public void delete(@PathVariable("email") String ema){
        studentService.delete(ema);
    }
}
