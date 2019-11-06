package com.magister.slim.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.magister.slim.entity.Group;
import com.magister.slim.entity.Student;
import com.magister.slim.entity.Teacher;
import com.magister.slim.references.CourseReference;
import com.magister.slim.references.GroupReference;
import com.magister.slim.references.OfferingLevelReference;
import com.magister.slim.references.StudentReference;
import com.magister.slim.references.StudyGuideReference;
import com.magister.slim.references.TeacherReference;
import com.magister.slim.repository.GroupInterface;

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

	public Group addGroup(Group group, TeacherReference teacherReference, List<StudentReference> students,
			StudyGuideReference studyGuide, OfferingLevelReference offeringLevel) {
		Teacher teacher = new Teacher();
		Student student = new Student();
		group.setActive(true);
		group.setGroupName("groupA");
		group.setGroupId(111);
		group.setCoursesreference(group.getCoursesreference());
		group.setTeacherReference(teacherDetails(teacherReference.getTeacherid(), teacherReference.getName()));
		group.setStudyGuideReference(studyGuideDetails(studyGuide.getStudyGuideId(), studyGuide.getStudyGuideName()));
		group.setStudents(studentDetails(1, "shreya"));
		group.setOfferingLevelReference(
				offeringLevelDetails(offeringLevel.getOfferingLevelid(), offeringLevel.getOfferingLevelName()));
		groupInterface.save(group);
		student.setId(1);
		student.setGroup(groupDetails(group.getGroupId(), group.getGroupName()));
		studentAppService.addStudent(student);
		teacher.setTeacherid(teacherReference.getTeacherid());
		teacher.setGroupReference(groupDetails(group.getGroupId(), group.getGroupName()));
		teacherAppService.addTeacher(teacher);
		return group;
	}

	public Group getGroup(int groupid) {
		Group group = groupInterface.findById(groupid).get();
		return group;
	}

	public Group updateGroup(Group group) {
		Group g = groupInterface.findById(group.getGroupId()).get();
		g.setCoursesreference(group.getCoursesreference());
		return g;
	}

	public List<Group> getGroups() {
		List<Group> groups = groupInterface.findAll();
		return groups;
	}

	public List<GroupReference> groupDetails(int id, String groupName) {
		GroupReference groupReference = new GroupReference();
		List<GroupReference> gR = new ArrayList<GroupReference>();
		groupReference.setGroupId(id);
		groupReference.setGroupName(groupName);
		gR.add(groupReference);
		return gR;
	}

	public List<CourseReference> courseDetails() {
		List<CourseReference> courseReference = new ArrayList<CourseReference>();
		CourseReference course = new CourseReference();
		course.setCourseId(121);
		course.setCourseName("English");
		courseReference.add(course);
		return courseReference;
	}

	public TeacherReference teacherDetails(int id, String teacherName) {
		TeacherReference teacherReference = new TeacherReference();
		teacherReference.setTeacherid(id);
		teacherReference.setName(teacherName);
		return teacherReference;
	}

	public OfferingLevelReference offeringLevelDetails(int id, String offeringLevelName) {
		OfferingLevelReference offeringLevelReference = new OfferingLevelReference();
		offeringLevelReference.setOfferingLevelid(id);
		offeringLevelReference.setOfferingLevelName(offeringLevelName);
		return offeringLevelReference;
	}

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
}
