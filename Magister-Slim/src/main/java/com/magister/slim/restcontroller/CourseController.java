package com.magister.slim.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.magister.slim.entity.Course;
import com.magister.slim.references.GroupReference;
import com.magister.slim.service.CourseAppService;
import com.magister.slim.service.GroupAppService;

@RestController
//@RequestMapping("offering/{offeringId}/offering-level/{offeringLevelId}/group/{groupId}/course")
@RequestMapping("course")
@CrossOrigin(origins = "http://localhost:4200")
public class CourseController {

	@Autowired
	CourseAppService courseAppService;
	@Autowired
	GroupAppService groupAppService;

	@RequestMapping(value = "", method = RequestMethod.POST)
	public Course addCourse(@PathVariable("offeringId") String offeringId,@PathVariable("offeringLevelId") String offeringLevelId,@PathVariable("groupId")String groupId,@RequestBody Course courseDetails) {
		courseDetails.setActive(true);
		GroupReference groupReference=groupAppService.getGroupReference(groupId,offeringLevelId);
		if(groupReference!=null)
		{
			Course status=courseAppService.addCourseDetails(groupReference,courseDetails);
			return status;
		}
		return null;
	}

	@RequestMapping(value = "/{courseId}", method = RequestMethod.DELETE)
	public Course removeCourse(@PathVariable("offeringId")String offeringId,@PathVariable("offeringLevelId") String offeringLevelId,@PathVariable("groupId") String groupId,@PathVariable("courseId")String courseId) {
		Course status=courseAppService.deleteCourse(groupId,courseId);
		return null;
	}
	
	@RequestMapping(value = "{courseId}", method = RequestMethod.PUT)
	public Course updateCourseDetails(@PathVariable("offeringId") String offeringId,@PathVariable("offeringLevelId") String offeringLevelId,@PathVariable("groupId")String groupId,@PathVariable("courseId")String courseId,@RequestBody Course course) {
		course.setCourseId(courseId);
		Course status=courseAppService.updateCourseDetails(groupId,course);
		return null;
	}
	
//	@RequestMapping(value = "{courseId}", method = RequestMethod.GET)
//	public Course getCourseDetails(@PathVariable("offeringId") int offeringId,@PathVariable("offeringLevelId") int offeringLevelId,@PathVariable("groupId") int groupId,@PathVariable("courseId")int courseId) {
//		Course coureDetails=courseAppService.getCourseDetailsById(groupId,courseId);
//		return coureDetails;
//
//	}
//	@GetMapping()
//	public Course getCourseDetailsByName(@PathVariable("offeringId") int offeringId,
//			@RequestParam("offeringLevelId") int offeringLevelId,@RequestParam("groupId")int groupId,@RequestParam("courseName") String courseName) {
//		return courseAppService.getCourseByName(groupId,courseName);
//
//	}
	@GetMapping()
	public List<Course> getAllCourses()
	{
	return courseAppService.getCourses();
	}
}
