package com.magister.slim.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.magister.slim.entity.Course;
import com.magister.slim.entity.StudyGuide;
import com.magister.slim.entity.Theme;
import com.magister.slim.entity.Unit;
import com.magister.slim.references.CourseReference;
import com.magister.slim.references.StudentReference;
import com.magister.slim.references.StudyGuideReference;
import com.magister.slim.references.TeacherReference;
import com.magister.slim.references.ThemeReference;
import com.magister.slim.references.UnitReference;
import com.magister.slim.repository.StudyGuideInterface;
import com.magister.slim.repository.ThemeInterface;
import com.magister.slim.repository.UnitInterface;

@Service
public class StudyGuideAppService {

	@Autowired
	StudyGuideInterface studyGuideInterface;
	@Autowired
	ThemeInterface themeInterface;
	@Autowired
	UnitInterface unitInterface;
	@Autowired
	CourseAppService courseAppService;

	public StudyGuide getStudyGuide(int studyGuideid) {
		if (studyGuideInterface.findById(studyGuideid).isPresent()) {
			StudyGuide studyGuide = studyGuideInterface.findById(studyGuideid).get();
			return studyGuide;
		} else
			return null;
	}

	public List<StudyGuide> getStudyGuide(String studyGuideName) {
		List<StudyGuide> studyGuide = studyGuideInterface.getStudyGuides(studyGuideName);
		return studyGuide;
	}

	public int deleteStudyGuide(int studyGuideId) {
		StudyGuide studyGuide = studyGuideInterface.findById(studyGuideId).get();
		studyGuide.setActive(false);
		List<ThemeReference> themeReferences = studyGuide.getThemes().stream().map(themeReference -> {
			themeReference.setActive(false);
			return themeReference;
		}).collect(Collectors.toList());
		studyGuide.setThemes(themeReferences);
		List<UnitReference> unitReferences = studyGuide.getUnits().stream().map(unitReference -> {
			unitReference.setActive(false);
			return unitReference;
		}).collect(Collectors.toList());
		studyGuide.setUnits(unitReferences);
		studyGuideInterface.save(studyGuide);
		return studyGuideId;
	}

	public StudyGuide updateStudyGuide(StudyGuide studyGuide, int studyGuideId) {
		StudyGuide sg = studyGuideInterface.findById(studyGuideId).get();
		if (studyGuide.getStudyGuideName() != null) {
			sg.setStudyGuideName(studyGuide.getStudyGuideName());
			if(sg.getThemes()!=null) {
			List<ThemeReference> themeReferences = sg.getThemes().stream().map(themeReference -> {
				Theme theme=themeInterface.findById(themeReference.getThemeId()).get();
				StudyGuideReference studyGuideReference = theme.getStudyGuideReference();
				studyGuideReference.setStudyGuideName(studyGuide.getStudyGuideName());
				theme.setStudyGuideReference(studyGuideReference);
				System.out.println(theme);
				themeInterface.save(theme);
				return themeReference;
			}).collect(Collectors.toList());
			sg.setThemes(themeReferences);}
			if(sg.getUnits()!=null) {
			List<UnitReference> unitReferences = sg.getUnits().stream().map(unitReference -> {
				Unit unit=unitInterface.findById(unitReference.getUnitId()).get();
				StudyGuideReference studyGuideReference = unit.getStudyGuideReference();
				studyGuideReference.setStudyGuideName(studyGuide.getStudyGuideName());
				unit.setStudyGuideReference(studyGuideReference);
				System.out.println(unit);
				unitInterface.save(unit);
				return unitReference;
			}).collect(Collectors.toList());
			sg.setUnits(unitReferences);}
		}
		if (studyGuide.getValidOnwards() != null) {
			sg.setValidOnwards(studyGuide.getValidOnwards());
		}
		if (studyGuide.getValidUpto() != null) {
			sg.setValidUpto(studyGuide.getValidUpto());
		}
		studyGuideInterface.save(sg);
		return sg;
	}

	public StudyGuide addStudyGuide(StudyGuide studyGuide) {
		Course course = new Course();
		studyGuide.setTeacherReference(teacherDetails(4, "Tom"));
		studyGuideInterface.save(studyGuide);
		course.setCourseId(studyGuide.getCourseReference().getCourseId());
		course.setStudyGuideReferences(
				studyGuideDetails(studyGuide.getStudyGuideIdId(), studyGuide.getStudyGuideName()));
		courseAppService.updateCourse(course);
		return studyGuide;
	}

	public List<StudyGuideReference> studyGuideDetails(int id, String studyGuideName) {
		StudyGuideReference studyGuideReference = new StudyGuideReference();
		List<StudyGuideReference> sR = new ArrayList<StudyGuideReference>();
		studyGuideReference.setStudyGuideId(id);
		studyGuideReference.setStudyGuideName(studyGuideName);
		studyGuideReference.setActive(true);
		sR.add(studyGuideReference);
		return sR;
	}

	public CourseReference courseDetails(int id, String courseName) {
		CourseReference courseReference = new CourseReference();
		courseReference.setCourseId(id);
		courseReference.setCourseName(courseName);
		courseReference.setActive(true);
		return courseReference;
	}

	public List<StudentReference> studentDetails(int id, String studentName) {
		StudentReference student = new StudentReference();
		List<StudentReference> studentReference = new ArrayList<StudentReference>();
		student.setId(id);
		student.setName(studentName);
		studentReference.add(student);
		return studentReference;
	}

	public TeacherReference teacherDetails(int id, String teacherName) {
		TeacherReference teacherReference = new TeacherReference();
		teacherReference.setTeacherid(id);
		teacherReference.setName(teacherName);
		teacherReference.setActive(true);
		return teacherReference;
	}

	public boolean deleteThemeReference(int themeId, int studyGuideId) {
		StudyGuide studyGuide = studyGuideInterface.findById(studyGuideId).get();
		List<ThemeReference> ThemeReferences = studyGuide.getThemes().stream().map(studyGuideReference -> {
			if (studyGuideReference.getThemeId() == themeId) {
				studyGuideReference.setActive(false);
			}
			return studyGuideReference;
		}).collect(Collectors.toList());
		studyGuide.setThemes(ThemeReferences);
		studyGuideInterface.save(studyGuide);
		return true;
	}
}
