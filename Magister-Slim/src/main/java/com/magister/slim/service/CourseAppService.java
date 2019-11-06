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
	
	public Course addCourse(Course course) {
		Group group=new Group();
		course.setStudyGuideReferences(course.getStudyGuideReferences());
		course.setCourseId(course.getCourseId());
		course.setActive(true);
		course.setCourseName(course.getCourseName());
		course.setGroupReferencs(course.getGroupReferencs());
		courseInterface.save(course);
		group.setGroupId(101);
		group.setGroupName("group1");
		group.setCoursesreference(courseDetails(course.getCourseId(),course.getCourseName()));
		groupAppService.updateGroup(group);
		return course;
	}
	public Course updateCourse(Course course)
	{
		Course c=courseInterface.findById(course.getCourseId()).get();
		c.setStudyGuideReferences(course.getStudyGuideReferences());
		c.setGroupReferencs(course.getGroupReferencs());
		courseInterface.save(c);
		return course;
	}
	public List<CourseReference> courseDetails(int id,String courseName)
	{
		List<CourseReference> courseReference=new ArrayList<CourseReference>();
		CourseReference course=new CourseReference();
		course.setCourseId(id);
		course.setCourseName(courseName);
		courseReference.add(course);
		return courseReference;
	}
	public List<GroupReference> groupDetails(int id,String groupName)
	{
		GroupReference groupReference=new GroupReference();
		List<GroupReference> gR=new ArrayList<GroupReference>();
		groupReference.setGroupId(id);
		groupReference.setGroupName(groupName);
		gR.add(groupReference);
		return gR;
	}
	public Course getCourse(int courseid) {
		Course course=courseInterface.findById(courseid).get();
		return course;
	}
	public List<Course> getCourses()
	{
		List<Course> course=courseInterface.findAll();
		return course;
	}
	public Course deleteCourse(Course course)
	{
		courseInterface.deleteById(course.getCourseId());
		return course;
	}
}
