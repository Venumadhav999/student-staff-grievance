package com.example.studentStaff.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.studentStaff.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
public class StudentController {

    @Autowired
    com.example.studentStaff.repository.StudentRepository studentRepository;

    @GetMapping("/students")

    public ResponseEntity<List<Student>> getAllStudents(@RequestParam(required = false) String department) {
        try {
            List<Student> students = new ArrayList<>();
            if (department == null) {
                studentRepository.findAll().forEach(students::add);
            } else {
                studentRepository.findByDepartment(department).forEach(students::add);
            }
            if (students.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(students, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") long id) {
        Optional<Student> studentData = studentRepository.findById(id);
        if (studentData.isPresent()) {
            return new ResponseEntity<>(studentData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/studentscreate")
public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        try {
            Student _student = studentRepository.save(new Student(0, student.getName(), student.getRegdNum(),
                    student.getDob(), student.getYear(), student.getDepartment()));
            return new ResponseEntity<>(_student, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}