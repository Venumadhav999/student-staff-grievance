package com.example.studentStaff.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.studentStaff.model.Complaint;
import com.example.studentStaff.service.ComplaintsServices;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ComplaintController {
 
    @Autowired
    private ComplaintsServices complaintService;  // Corrected the type

    @PostMapping("/complaint")
    public ResponseEntity<String> submitComplaint(@RequestBody Complaint complaint) {
        complaintService.addComplaint(complaint);
        return ResponseEntity.ok("Complaint submitted successfully");
    }

    @GetMapping("/get")
    public List<Complaint> getComplaints() {
        return complaintService.findAllComplaints();
    }

    @GetMapping("/get/{department}")
    public List<Complaint> getDepartmentComplaints(@PathVariable String department) {
        return complaintService.findDepartmentComplaints(department);
    }

    @PutMapping("/status/{id}")
    public ResponseEntity<Complaint> updateComplaintStatus(@PathVariable Long id, @RequestParam String newStatus) {
        Complaint updatedComplaint = complaintService.updateComplaintStatus(id, newStatus);
        return ResponseEntity.ok(updatedComplaint);
    }
}

    

	