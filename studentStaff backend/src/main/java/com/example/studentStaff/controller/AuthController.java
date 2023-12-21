package com.example.studentStaff.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.studentStaff.model.HOD;
import com.example.studentStaff.model.Management;
import com.example.studentStaff.model.Staff;
import com.example.studentStaff.model.Student;
import com.example.studentStaff.model.auth.AuthRequest;
import com.example.studentStaff.repository.HODRepository;
import com.example.studentStaff.repository.ManagementRepository;
import com.example.studentStaff.repository.StaffRepository;
import com.example.studentStaff.repository.StudentRepository;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StaffRepository staffRepository;

    @Autowired
    private HODRepository hodRepository;

    @Autowired
    private ManagementRepository managementRepository;

    @PostMapping("/student")
    public ResponseEntity<String> authenticateStudent(@RequestBody AuthRequest authRequest) {
        
        Student student = studentRepository.findByRegdNumAndDobAndDepartment(
                authRequest.getRegdNum(),
                authRequest.getDob(),
                authRequest.getDepartment()
        );

        if (student != null) {
            
            return new ResponseEntity<>("Student Verification Successful", HttpStatus.OK);
        } else {
           
            return new ResponseEntity<>("Student Verification Failed", HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("/staff")
    public ResponseEntity<String> authenticateStaff(@RequestBody AuthRequest authRequest) {
        // Assuming StaffRepository has the appropriate method for authentication
        Staff staff = staffRepository.findByNameAndPasswordAndDepartment(
                authRequest.getName(),
                authRequest.getPassword(),
                authRequest.getDepartment()
        );

        if (staff != null) {
            // Successful authentication
            return new ResponseEntity<>("Staff Verification Successful", HttpStatus.OK);
        } else {
            // Failed authentication
            return new ResponseEntity<>("Staff Verification Failed", HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("/hod")
    public ResponseEntity<String> authenticateHOD(@RequestBody AuthRequest authRequest) {
        // Assuming HODRepository has the appropriate method for authentication
        HOD hod = hodRepository.findByNameAndPasswordAndDepartment(
                authRequest.getName(),
                authRequest.getPassword(),
                authRequest.getDepartment()
        );

        if (hod != null) {
            // Successful authentication
            return new ResponseEntity<>("HOD Verification Successful", HttpStatus.OK);
        } else {
            // Failed authentication
            return new ResponseEntity<>("HOD verification Failed", HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("/management")
    public ResponseEntity<String> authenticateManagement(@RequestBody AuthRequest authRequest) {
        // Assuming ManagementRepository has the appropriate method for authentication
        Management management = managementRepository.findByNameAndPasswordAndPosition(
                authRequest.getName(),
                authRequest.getPassword(),
                authRequest.getPosition()
        );

        if (management != null) {
          
            return new ResponseEntity<>("Management Verification Successful", HttpStatus.OK);
        } else {
           
            return new ResponseEntity<>("Management verification failed", HttpStatus.UNAUTHORIZED);
        }
    }

    
}
    

