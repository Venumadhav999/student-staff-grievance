package com.example.studentStaff.service;
   
import java.util.List;

import com.example.studentStaff.model.Complaint;



public interface ComplaintsServices {
   
	public Complaint addComplaint(Complaint complaint);
	
	public List<Complaint> findAllComplaints();
	
	public List<Complaint> findDepartmentComplaints(String department);
	
	public Complaint updateComplaintStatus(long complaintId,String status);
}
    

