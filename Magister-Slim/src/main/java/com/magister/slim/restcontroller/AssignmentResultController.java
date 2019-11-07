package com.magister.slim.restcontroller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.magister.slim.entity.Assignment;
import com.magister.slim.entity.AssignmentResult;
import com.magister.slim.entity.Student;
import com.magister.slim.references.AssignmentReference;
import com.magister.slim.references.StudentReference;
import com.magister.slim.repository.AssignmentInterface;
import com.magister.slim.repository.StudentInterface;
import com.magister.slim.service.AssignmentResultAppService;

@RestController
@RequestMapping("student/{studentId}/studyguide/{studyGuideId}/theme/{themeId}/unit/{unitId}/assignment/{assignmentId}/assignmentResult")
@CrossOrigin(origins = "http://localhost:4200")
public class AssignmentResultController {

	@Autowired
	AssignmentInterface assignmentInterface;
	@Autowired
	StudentInterface studentInterface;
	@Autowired
	AssignmentResultAppService assignmentResultAppService;
	
	StudentReference studentReference=new StudentReference();
	Student student=new Student();
	AssignmentReference assignmentReference=new AssignmentReference();
	Assignment assignment=new Assignment();
	@RequestMapping(method = RequestMethod.POST)
	public AssignmentResult createAssignmentResult(@RequestBody AssignmentResult assignmentResult,
			@PathVariable("studentId") int studentId, @PathVariable("assignmentId") int assignmentId,@PathVariable("unitId") int unitId) {
		assignment=assignmentInterface.findById(assignmentId).get();
		assignmentReference.setAssignmentId(assignment.getAssignmentId());
		assignmentReference.setAssignmentName(assignment.getAssignmentName());
		student=studentInterface.findById(studentId).get();
		studentReference.setId(student.getid());
		studentReference.setName(student.getName());
		AssignmentResult status = assignmentResultAppService.addAssignmentResult(assignmentResult,unitId);
		return status;
	}

	@RequestMapping(value = "/{assignmentResultId}", method = RequestMethod.DELETE)
	public AssignmentResult deleteAssignmentResultdetails(@RequestBody AssignmentResult assignmentResult,
			@PathVariable("assignmentResultId") int assignmentResultId) {
		AssignmentResult status = assignmentResultAppService.deleteAssignmentResult(assignmentResult);
		return status;
	}

	@RequestMapping(value = "/{assignmentResultId}", method = RequestMethod.PUT)
	public AssignmentResult updateAssignmentResultdetails(@RequestBody AssignmentResult assignmentResult,
			@PathVariable("assignmentResultId") int assignmentResultId) {
		AssignmentResult status = assignmentResultAppService.updateAssignmentResult(assignmentResult);
		return status;
	}

	@RequestMapping(value = "/{assignmentResultId}", method = RequestMethod.GET)
	public AssignmentResult getAssignmentResultDetail(@PathVariable("assignmentResultId") int assignmentResultId) {
		AssignmentResult assignmentResult = assignmentResultAppService.getAssignmentResult(assignmentResultId);
		return assignmentResult;
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<AssignmentResult> getAssignmentResultdetails(@RequestParam int assignmentResultId) {
		List<AssignmentResult> assignmentResults = assignmentResultAppService.getAssignmentResults();
		return assignmentResults;
	}

}
