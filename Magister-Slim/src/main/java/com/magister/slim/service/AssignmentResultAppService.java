package com.magister.slim.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.magister.slim.entity.AssignmentResult;
import com.magister.slim.repository.AssignmentResultInterface;

@Service
public class AssignmentResultAppService {

	@Autowired
	AssignmentResultInterface assignmentResultInterface;

	public List<AssignmentResult> getAssignmentResults() {
		List<AssignmentResult> assignmentResults = assignmentResultInterface.findAll();
		return assignmentResults;
	}

	public AssignmentResult deleteAssignmentResult(AssignmentResult assignmentResult) {
		assignmentResultInterface.deleteById(assignmentResult.getAssignedMarks());
		return assignmentResult;
	}

	public AssignmentResult addAssignmentResult(AssignmentResult assignmentResult) {
		assignmentResultInterface.save(assignmentResult);
		return assignmentResult;
	}

	public AssignmentResult getAssignmentResult(int assignmentResultid) {
		AssignmentResult assignment = assignmentResultInterface.findById(assignmentResultid).get();
		return assignment;
	}
}
