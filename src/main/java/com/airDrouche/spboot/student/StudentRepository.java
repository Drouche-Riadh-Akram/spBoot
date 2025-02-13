package com.airDrouche.spboot.student;

import org.springframework.data.jpa.repository.JpaRepository;

//@Repository no need since it extends JpaRepository
public interface StudentRepository extends JpaRepository<Student,Integer> {
Student findByEmail(String email);
void deleteByEmail(String email);
}
