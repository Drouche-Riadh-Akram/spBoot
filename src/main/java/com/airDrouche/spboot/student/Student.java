package com.airDrouche.spboot.student;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

@Entity
//@Table usefull when table has different name than entity
public class Student {
    //    firstName lastName dateOfBirth email age
    @Id
    @GeneratedValue
    private Integer id;
    @Column // not mandatory since there is ORM mapping and same name
    private String firstName;

    private String lastName;
    private LocalDate dateOfBirth;
    @Column(unique = true)
    private String email;
    @Transient // i don't want it to persist
    private int age;

    public Student() {
    }

    public Student(String firstName, String lastName, LocalDate dateOfBirth, String email, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.age = age;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
       return Period.between(dateOfBirth,LocalDate.now()).getYears();
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
