package com.magister.slim.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.magister.slim.entity.Course;
import com.magister.slim.entity.Group;
import com.magister.slim.entity.Offering;
import com.magister.slim.entity.OfferingLevel;
import com.magister.slim.entity.Student;
import com.magister.slim.entity.Teacher;
import com.magister.slim.references.CourseReference;
import com.magister.slim.references.GroupReference;
import com.magister.slim.references.OfferingLevelReference;
import com.magister.slim.references.StudentReference;
import com.magister.slim.references.StudyGuideReference;
import com.magister.slim.references.TeacherReference;
import com.magister.slim.repository.CourseInterface;
import com.magister.slim.repository.GroupInterface;
import com.magister.slim.repository.OfferingInterface;
import com.magister.slim.repository.OfferingLevelInterface;
import com.magister.slim.repository.TeacherInterface;

@Service
public class GroupAppService {

	@Autowired
	GroupInterface groupInterface;
	@Autowired
	CourseAppService courseAppService;
	@Autowired
	TeacherAppService teacherAppService;
	@Autowired
	StudentAppService studentAppService;
	@Autowired
	OfferingLevelAppService offeringLevelAppService;
	@Autowired
	OfferingLevelInterface offeringLevelInterface;
	@Autowired
	CourseInterface courseInterface;
	@Autowired
	TeacherInterface teacherInterface;

	public StudyGuideReference studyGuideDetails(int id, String studyGuideName) {
		StudyGuideReference studyGuideReference = new StudyGuideReference();
		studyGuideReference.setStudyGuideId(id);
		studyGuideReference.setStudyGuideName(studyGuideName);
		return studyGuideReference;
	}

	public List<StudentReference> studentDetails(int id, String studentName) {
		StudentReference student = new StudentReference();
		List<StudentReference> studentReference = new ArrayList<StudentReference>();
		student.setId(id);
		student.setName(studentName);
		studentReference.add(student);
		return studentReference;
	}

	public Group deleteGroup(Group group) {
		groupInterface.deleteById(group.getGroupId());
		return group;
	}

	public Group addGroupDetails(Group groupDetails) {
		if (groupInterface.save(groupDetails) != null) {

			offeringLevelAppService.updateGroupReferences(groupDetails);
			teacherAppService.updateGroupReferences(groupDetails);
			return groupDetails;
		} else
			return null;
	}

	public Group deleteGroup(int offeringId, int offeringLevelId, int groupId) {
		if (groupInterface.findById(groupId).isPresent()) {
			Group group = groupInterface.findById(groupId).get();
			if (group.getOfferingLevelReference().getOfferingLevelId() == offeringLevelId) {
				group.setActive(false);
				groupInterface.save(group);
				boolean status = offeringLevelAppService.deleteGroupReference(offeringLevelId, groupId);
			}
			return group;
		}
		return null;
	}

	public Group updateGroupDetails(int offeringId, Group groupDetails) {

		if (groupInterface.findById(groupDetails.getGroupId()).isPresent()) {
			Group group = groupInterface.findById(groupDetails.getGroupId()).get();
			group.setGroupName(groupDetails.getGroupName());
			groupInterface.save(group);
			boolean status = offeringLevelAppService.updateGroupReferenceDetails(groupDetails);
			return groupDetails;
		}
		return null;
	}

	public GroupReference getGroupReference(int groupId, int offeringLevelId) {
		if (groupInterface.findById(groupId).isPresent()) {
			Group groupDetails = groupInterface.findById(groupId).get();
			if (groupDetails.getOfferingLevelReference().getOfferingLevelId() == offeringLevelId
					&& groupDetails.isActive() == true)
				return new GroupReference(groupDetails.getGroupId(), groupDetails.getGroupName(), true);
			else
				return null;
		}
		return null;
	}

	public boolean updateCourseReferences(GroupReference groupReference, Course courseDetails) {
		List<CourseReference> courseReferences = new ArrayList<CourseReference>();
		if (groupInterface.findById(groupReference.getGroupId()).isPresent()) {
			Group groupDetails = groupInterface.findById(groupReference.getGroupId()).get();
			courseReferences = groupDetails.getCoursesreference();
			if (courseReferences == null)
				courseReferences = new ArrayList<CourseReference>();
			courseReferences.add(new CourseReference(courseDetails.getCourseId(), courseDetails.getCourseName(), true));
			groupDetails.setCoursesreference(courseReferences);
			if (groupInterface.save(groupDetails) != null)
				return true;
			else
				return false;
		}
		return false;
	}

	public boolean deleteCourseReference(int groupId, int courseId) {
		Group groupDetails = groupInterface.findById(groupId).get();
		List<CourseReference> courseReferences = (groupDetails.getCoursesreference()).stream().map(courseReference -> {
			if (courseReference.getCourseId() == courseId) {
				courseReference.setActive(false);
			}
			return courseReference;
		}).collect(Collectors.toList());
		groupDetails.setCoursesreference(courseReferences);
		if(groupInterface.save(groupDetails)!=null)
		return true;
		else
			return false;
	}

	public boolean updateCourseReferenceDetails(int groupId, Course course) {
		Group groupDetails = groupInterface.findById(groupId).get();
		List<CourseReference> courseReferences = (groupDetails.getCoursesreference()).stream().map(courseReference -> {
			if (courseReference.getCourseId() == course.getCourseId()) {
				courseReference.setCourseName(course.getCourseName());
			}
			return courseReference;
		}).collect(Collectors.toList());
		groupDetails.setCoursesreference(courseReferences);
		if(groupInterface.save(groupDetails)!=null)
		return true;
		else
			return false;
	}

	public Group getGroupDetailsById(int offeringLevelId, int groupId) {
		if ((groupInterface.findById(groupId).isPresent())) {
			Group groupDetails = groupInterface.findById(groupId).get();
			if (groupDetails.getOfferingLevelReference().getOfferingLevelId() == offeringLevelId)
				return groupDetails;
			else
				return null;
		} else
			return null;
	}

	public Group getGroupByName(int offeringLevelId, String groupName) {
		Group groupDetails = groupInterface.getGroupByName(groupName);
		if (groupDetails != null && groupDetails.getOfferingLevelReference().getOfferingLevelId() == offeringLevelId)
			return groupDetails;
		else
			return null;
	}

	public boolean deleteOfferingLevelreference(int offeringLevelId) {
		OfferingLevel offeringLevel = offeringLevelInterface.findById(offeringLevelId).get();
		List<GroupReference> groupReferences = (offeringLevel.getGroupReferences()).stream().map(groupReference -> {
			groupReference.setActive(false);
			Group group=groupInterface.findById(groupReference.getGroupId()).get();
			group.setActive(false);
			group.getOfferingLevelReference().setActive(false);
			group=deleteCourseReferences(group);
			groupInterface.save(group);
			return groupReference;
		}).collect(Collectors.toList());
		offeringLevel.setGroupReferences(groupReferences);
		offeringLevelInterface.save(offeringLevel);
		return true;
	}
	public Group deleteCourseReferences(Group group)
	{
		List<CourseReference> courseReferences = (group.getCoursesreference()).stream().map(courseReference -> {
			
			courseReference.setActive(false);
			Course course=courseInterface.findById(courseReference.getCourseId()).get();
			course.setActive(false);
			course=deleteGroupReferences(course,group);
			courseInterface.save(course);
			return courseReference;
		}).collect(Collectors.toList());
		group.setCoursesreference(courseReferences);
		return group;
		
	}

	private Course deleteGroupReferences(Course course, Group group) {
		
		List<GroupReference> groupReferences = course.getGroupReferences().stream().map(groupReference -> {
			if (groupReference.getGroupId() == group.getGroupId()) {
				groupReference.setActive(false);	
			}
			return groupReference;
		}).collect(Collectors.toList());
		course.setGroupReferences(groupReferences);
		return course;
	}

	public boolean deleteTeacherReference(Teacher teacherDetails) {
		if(teacherInterface.findById(teacherDetails.getTeacherId()).isPresent())
		{
		Teacher teacher = teacherInterface.findById(teacherDetails.getTeacherId()).get();
		List<GroupReference> groupReferences = (teacher.getGroupReference()).stream().map(groupReference -> {
			groupReference.setActive(false);
			Group group=groupInterface.findById(groupReference.getGroupId()).get();
			group.setActive(false);
			group.getTeacherReference().setActive(false);
			groupInterface.save(group);
			return groupReference;
		}).collect(Collectors.toList());
		teacher.setGroupReference(groupReferences);
		teacherInterface.save(teacher);
		return true;
		}
		return false;

	}

	public boolean updateTeacherReferenceDetails(Teacher teacherDetails) {
		if(teacherInterface.findById(teacherDetails.getTeacherId()).isPresent())
		{
		Teacher teacher = teacherInterface.findById(teacherDetails.getTeacherId()).get();
		List<GroupReference> groupReferences = (teacher.getGroupReference()).stream().map(groupReference -> {
			Group group=groupInterface.findById(groupReference.getGroupId()).get();
			group.getTeacherReference().setName(teacherDetails.getName());
			groupInterface.save(group);
			return groupReference;
		}).collect(Collectors.toList());
		teacher.setGroupReference(groupReferences);
		teacherInterface.save(teacher);
		return true;
		}
		return false;

	}
}
