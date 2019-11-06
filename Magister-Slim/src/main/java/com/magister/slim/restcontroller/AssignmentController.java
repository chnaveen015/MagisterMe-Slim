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
import com.magister.slim.references.StudyGuideReference;
import com.magister.slim.references.ThemeReference;
import com.magister.slim.references.UnitReference;
import com.magister.slim.service.AssignmentAppService;

@RestController
@RequestMapping("studyguide/{studyGuideId}/theme/{themeId}/unit/{unitId}/assignment")
@CrossOrigin(origins = "http://localhost:4200")

public class AssignmentController {

	@Autowired
	AssignmentAppService assignmentAppService;

	Assignment assignment = new Assignment();
	StudyGuideReference studyGuideReference = new StudyGuideReference();
	ThemeReference theme = new ThemeReference();
	UnitReference unit = new UnitReference();

	@RequestMapping(value = "", method = RequestMethod.POST)
	public Assignment add(@RequestBody Assignment assignment) {
		Assignment status = assignmentAppService.addAssignment(assignment);
		return status;
	}

	@RequestMapping(value = "/{assignmentId}", method = RequestMethod.DELETE)
	public int delete(@PathVariable("assignmentId") int assignmentId) {
		int status = assignmentAppService.deleteAssignment(assignmentId);
		return status;
	}

	@RequestMapping(value = "/{assignmentId}", method = RequestMethod.PUT)
	public Assignment update(@PathVariable("assignmentId") int assignmentId, @RequestBody Assignment assignment) {
		assignment.setAssignmentId(assignmentId);
		Assignment status = assignmentAppService.addAssignment(assignment);
		return status;
	}

	@RequestMapping(method = RequestMethod.GET)
	public Assignment get(@RequestParam int assignmentId) {
		Assignment assignment = assignmentAppService.getAssignment(assignmentId);
		return assignment;

	}

	@RequestMapping(value = "/{assignmentName}", method = RequestMethod.GET)
	public List<Assignment> get(@PathVariable("assignmentName") String assignmentName) {
		List<Assignment> assignments = assignmentAppService.getAssignments(assignmentName);
		return assignments;
	}
}
