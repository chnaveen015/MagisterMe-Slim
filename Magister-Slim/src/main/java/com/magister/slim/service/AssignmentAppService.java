package com.magister.slim.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.magister.slim.entity.Assignment;
import com.magister.slim.repository.AssignmentInterface;

@Service
public class AssignmentAppService {
	
	@Autowired
	AssignmentInterface assignmentInterface;
	
	public List<Assignment> getAssignments(String assignmentName)
	{
		List<Assignment> assignments=assignmentInterface.getAssignments(assignmentName);
		return assignments;
	}
	public int deleteAssignment(int assignmentId)
	{
		assignmentInterface.deleteById(assignmentId);
		return assignmentId;
	}
	public Assignment addAssignment(Assignment assignment)
	{
		assignmentInterface.save(assignment);
		return assignment;
	}
	public Assignment getAssignment(int assignmentid) {
		Assignment assignment=assignmentInterface.findById(assignmentid).get();
		return assignment;
	}

}
