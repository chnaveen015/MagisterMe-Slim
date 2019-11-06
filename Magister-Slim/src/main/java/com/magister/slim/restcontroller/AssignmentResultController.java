package com.magister.slim.restcontroller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.magister.slim.entity.AssignmentResult;
import com.magister.slim.service.AssignmentResultAppService;

@RestController
@RequestMapping("studyguide/{studyGuideId}/theme/{themeId}/unit/{unitId}/assignment/{assignmentId}/assignmentResult")
@CrossOrigin(origins = "http://localhost:4200")
public class AssignmentResultController {

	@Autowired
	AssignmentResultAppService assignmentResultAppService;

	@RequestMapping(value = "", method = RequestMethod.POST)
	public AssignmentResult add(@RequestBody AssignmentResult assignmentResult) {
		AssignmentResult status = assignmentResultAppService.addAssignmentResult(assignmentResult);
		return status;
	}

	@RequestMapping(value = "/{assignmentResultId}",method = RequestMethod.DELETE)
	public AssignmentResult delete(@RequestBody AssignmentResult assignmentResult,@PathVariable("assignmentResultId") int assignmentResultId) {
		AssignmentResult status = assignmentResultAppService.deleteAssignmentResult(assignmentResult);
		return status;
	}
	
	@RequestMapping(value = "/{assignmentResultId}",method = RequestMethod.PUT)
	public AssignmentResult update(@RequestBody AssignmentResult assignmentResult) {
		AssignmentResult status = assignmentResultAppService.addAssignmentResult(assignmentResult);
		return status;
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<AssignmentResult> get() {
		List<AssignmentResult> assignmentResults = assignmentResultAppService.getAssignmentResults();
		return assignmentResults;
	}

}
