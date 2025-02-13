package com.airDrouche.spboot.student;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
//@Service("prioImpl") and use prioImpl on controller cnstructor with @Qualifier
//@Primary to make it the default implementation
public class InMemoryStudentService implements StudentService{
    private final InMemoryStudentDao dao;

    public InMemoryStudentService(InMemoryStudentDao dao) {
        this.dao = dao;
    }

    @Override
    public Student save(Student student) {
        return dao.save(student);
    }

    @Override
    public List<Student> findAllStudents() {
       return dao.findAllStudents();
    }

    @Override
    public Student findByEmail(String email) {
        return dao.findByEmail(email);
    }

    @Override
    public Student update(Student student) {
        return dao.update(student);
    }

    @Override
    public void delete(String email) {
    dao.delete(email);
    }
}
