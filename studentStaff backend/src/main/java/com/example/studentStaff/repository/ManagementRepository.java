package com.example.studentStaff.repository;  
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.studentStaff.model.Management;

public interface ManagementRepository extends JpaRepository<Management, Long> {
    Management findByNameAndPasswordAndPosition(String name, String password, String position);
    List<Management> findByPosition(String position);
}
    

