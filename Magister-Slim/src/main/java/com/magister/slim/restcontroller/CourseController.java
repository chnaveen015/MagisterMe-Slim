package com.magister.slim.restcontroller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.magister.slim.entity.Course;
import com.magister.slim.entity.Group;
import com.magister.slim.references.GroupReference;
import com.magister.slim.service.CourseAppService;
import com.magister.slim.service.GroupAppService;

@RestController
@RequestMapping("offering/{offeringId}/offering-level/{offeringLevelId}/group/{groupId}/course")
@CrossOrigin(origins = "http://localhost:4200")
public class CourseController {

	@Autowired
	CourseAppService courseAppService;
	@Autowired
	GroupAppService groupAppService;

	@RequestMapping(value = "", method = RequestMethod.POST)
	public Course addCourse(@PathVariable("offeringId") int offeringId,@PathVariable("offeringLevelId") int offeringLevelId,@PathVariable("groupId")int groupId,@RequestBody Course courseDetails) {
		GroupReference groupReference=groupAppService.getGroupReference(groupId,offeringLevelId);
		if(groupReference!=null)
		{
			Course status=courseAppService.addCourseDetails(groupReference,courseDetails);
			return status;
		}
		return null;
	}

	@RequestMapping(value = "/{courseId}", method = RequestMethod.DELETE)
	public Course removeCourse(@PathVariable("offeringId")int offeringId,@PathVariable("offeringLevelId") int offeringLevelId,@PathVariable("groupId") int groupId,@PathVariable("courseId")int courseId) {
		Course status=courseAppService.deleteCourse(groupId,courseId);
		return null;
	}
	
	@RequestMapping(value = "{courseId}", method = RequestMethod.PUT)
	public Course updateCourseDetails(@PathVariable("offeringId") int offeringId,@PathVariable("offeringLevelId") int offeringLevelId,@PathVariable("groupId")int groupId,@PathVariable("courseId")int courseId,@RequestBody Course course) {
		course.setCourseId(courseId);
		Course status=courseAppService.updateCourseDetails(groupId,course);
		return null;
	}
	
	@RequestMapping(value = "{courseId}", method = RequestMethod.GET)
	public Course getCourseDetails(@PathVariable("offeringId") int offeringId,@PathVariable("offeringLevelId") int offeringLevelId,@PathVariable("groupId") int groupId,@PathVariable("courseId")int courseId) {
		Course coureDetails=courseAppService.getCourseDetailsById(groupId,courseId);
		return coureDetails;

	}
	@GetMapping()
	public Course getCourseDetailsByName(@PathVariable("offeringId") int offeringId,
			@RequestParam("offeringLevelId") int offeringLevelId,@RequestParam("groupId")int groupId,@RequestParam("courseName") String courseName) {
		return courseAppService.getCourseByName(groupId,courseName);

	}
}
