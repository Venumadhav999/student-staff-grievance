package com.example.studentStaff.repository;
   
import java.io.Serializable;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.studentStaff.model.Complaint;



public interface ComplaintRepository extends JpaRepository<Complaint,Serializable> {

	public List<Complaint> findByDepartment(String department);	

}
    

