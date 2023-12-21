package com.example.studentStaff.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.studentStaff.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByRegdNumAndDobAndDepartment(String regdNum, String dob, String department);
    List<Student> findByDepartment(String department);
}

