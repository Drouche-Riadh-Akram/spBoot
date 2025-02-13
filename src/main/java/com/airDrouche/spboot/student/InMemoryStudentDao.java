package com.airDrouche.spboot.student;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
@Repository
public class InMemoryStudentDao {
    private final List<Student> studentList=new ArrayList<>();

    public Student save(Student student) {
        studentList.add(student);
        return student;
    }

    public List<Student> findAllStudents() {
        return studentList;
    }

    public Student findByEmail(String email) {
        return  studentList.stream().filter(student -> email.equals(student.getEmail())).findFirst().orElse(null);
    }

    public Student update(Student student) {
        var studentIndex= IntStream.range(0,studentList.size())
                .filter(index->studentList.get(index).getEmail().equals(student.getEmail())).findFirst().orElse(-1);
    if (studentIndex!=-1){
        studentList.set(studentIndex,student);
        return student;
    }
    return null;
    }

    public void delete(String email) {
        var student= findByEmail(email);
        if(student!=null){
            studentList.remove(student);
        }

    }
}
