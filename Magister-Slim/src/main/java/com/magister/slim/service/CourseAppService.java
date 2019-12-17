package com.magister.slim.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.magister.slim.entity.Course;
import com.magister.slim.entity.Group;
import com.magister.slim.references.CourseReference;
import com.magister.slim.references.GroupReference;
import com.magister.slim.repository.CourseInterface;

@Service
public class CourseAppService {
	
	@Autowired
	CourseInterface courseInterface;
	@Autowired
	GroupAppService groupAppService;

	public Course getCourse(String courseid) {
		Course course=courseInterface.findById(courseid).get();
		return course;
	}
	public List<Course> getCourses()
	{
		List<Course> course=courseInterface.findAll();
		return course;
	}
	
	public Course addCourseDetails(GroupReference groupReference, Course courseDetails) {
		if(courseInterface.save(courseDetails)!=null)
		{
			if(updateGroupReference(groupReference,courseDetails) && groupAppService.updateCourseReferences(groupReference,courseDetails))
			{
			
					return courseDetails;
			}
			else
				return null;
		}
			
		return null;
	}
	public boolean updateGroupReference(GroupReference groupReference,Course courseDetails)
	{
		List<GroupReference> groupReferences = new ArrayList<GroupReference>();
		if(courseInterface.findById(courseDetails.getCourseId()).isPresent())
		{
		Course course = courseInterface.findById(courseDetails.getCourseId()).get();
		groupReferences = course.getGroupReferences();
		if (groupReferences == null)
			groupReferences = new ArrayList<GroupReference>();
		groupReferences.add(groupReference);
		course.setGroupReferences(groupReferences);
		if(courseInterface.save(course)!=null)
			return true;
		else
			return false;
		}
	return false;
	}
	public Course deleteCourse(String groupId, String courseId) {
		if(courseInterface.findById(courseId).isPresent())
		{
		Course courseDetails=courseInterface.findById(courseId).get();
			courseDetails.setActive(false);
			courseInterface.save(courseDetails);
			boolean status=groupAppService.deleteCourseReference(groupId,courseId);
		   return courseDetails;
		}
		return null;
	}
	public Course updateCourseDetails(String groupId, Course course) {
		if (courseInterface.findById(course.getCourseId()).isPresent()) {
			Course courseDetails = courseInterface.findById(course.getCourseId()).get();
			courseDetails.setCourseName(course.getCourseName());
			courseInterface.save(courseDetails);
			boolean status = groupAppService.updateCourseReferenceDetails(groupId,course);
			return courseDetails;
		}
		return null;
	}
	public Course getCourseDetailsById(int groupId, String courseId) {
		if ((courseInterface.findById(courseId).isPresent())) {
			Course courseDetails = courseInterface.findById(courseId).get();
				return courseDetails;

		} else
			return null;

	}
	public Course getCourseByName(int groupId, String courseName) {
		Course courseDetails = courseInterface.getCourseByName(courseName);
		if (courseDetails != null)
			return courseDetails;
		else
			return null;
	}
	}


