package com.magister.slim.restcontroller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.magister.slim.entity.Assignment;
import com.magister.slim.service.AssignmentAppService;

@RestController
@RequestMapping("studyGuide/{studyGuideId}/theme/{themeId}/unit/{unitId}/assignment")
@CrossOrigin(origins = "http://localhost:4200")

public class AssignmentController {

	@Autowired
	AssignmentAppService assignmentAppService;

	@RequestMapping(value = "", method = RequestMethod.POST)
	public Assignment addassignment(@RequestBody Assignment assignment) {
		Assignment status = assignmentAppService.addAssignment(assignment);
		return status;
	}

	@RequestMapping(value = "/{assignmentId}", method = RequestMethod.DELETE)
	public Assignment deleteAssignmentDetails(@RequestParam("assignmentId") int assignmentId) {
		//Assignment status = assignmentAppService.deleteAssignment(assignment);
		return null;
	}
	
	@RequestMapping(value = "{assignmentId}", method = RequestMethod.PUT)
	public Assignment updateAssignmentDetails(@RequestParam("assignmentId") int assignmentId,@RequestBody(required=false) Assignment assignment) {
//		Assignment status = assignmentAppService.addAssignment(assignment);
		return null;
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<Assignment> getAssignmentDetails() {
		List<Assignment> assignments = assignmentAppService.getAssignments();
		return assignments;
	}

}
