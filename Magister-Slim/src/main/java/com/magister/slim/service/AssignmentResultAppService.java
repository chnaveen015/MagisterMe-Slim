package com.magister.slim.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.magister.slim.entity.Assignment;
import com.magister.slim.entity.AssignmentResult;
import com.magister.slim.entity.Unit;
import com.magister.slim.references.AssignmentReference;
import com.magister.slim.references.AssignmentResultReference;
import com.magister.slim.references.ThemeReference;
import com.magister.slim.repository.AssignmentInterface;
import com.magister.slim.repository.AssignmentResultInterface;
import com.magister.slim.repository.UnitInterface;

@Service
public class AssignmentResultAppService {

	@Autowired
	AssignmentResultInterface assignmentResultInterface;
	@Autowired
	AssignmentInterface assignmentInterface;

	public List<AssignmentResult> getAssignmentResults() {
		List<AssignmentResult> assignmentResults = assignmentResultInterface.findAll();
		return assignmentResults;
	}

	public AssignmentResult deleteAssignmentResult(AssignmentResult assignmentResult) {
		assignmentResultInterface.deleteById(assignmentResult.getAssignedMarks());
		return assignmentResult;
	}

	public AssignmentResult addAssignmentResult(AssignmentResult assignmentResult, int unitId) {
		assignmentResultInterface.save(assignmentResult);
	//	assignmentResult=assignmentResultInterface.findById(assignmentResult.getAssignmentReference().getAssignmentId()).get();
	//	assignmentResult.setAssignmentReference(assignmentDetails(assignmentResult.getAssignmentReference().,assignmentResult));
		return assignmentResult;
	}

	private List<AssignmentResultReference> assignmentDetails(int assignmentId,
			AssignmentResult assignmentResult) {
		AssignmentReference assignmentReference = new AssignmentReference();
		List<AssignmentResultReference> assignmentResults = new ArrayList<AssignmentResultReference>();
		assignmentResults = assignmentResult.getAssignmentReference();
		if (assignmentResults == null)
			assignmentResults = new ArrayList<AssignmentResultReference>();
//		assignmentReference.setAssignmentResultId(assignmentId);
//		assignmentResults.add(assignmentReference);
		return assignmentResults;
	}

	public AssignmentResult getAssignmentResult(int assignmentResultid) {
		AssignmentResult assignmentResult = assignmentResultInterface.findById(assignmentResultid).get();
		return assignmentResult;
	}

	public AssignmentResult updateAssignmentResult(AssignmentResult assignmentResult) {
		// TODO Auto-generated method stub
		return null;
	}

}
