package com.magister.slim.restcontroller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.magister.slim.entity.Teacher;
import com.magister.slim.service.TeacherAppService;

@RestController
@RequestMapping("teacher")
@CrossOrigin(origins = "http://localhost:4200")
public class TeacherController {
	@Autowired
	TeacherAppService teacherAppService;

	@RequestMapping(value = "", method = RequestMethod.POST)
	public Teacher add(@RequestBody Teacher student) {
		Teacher status = teacherAppService.addTeacher(student);
		System.out.println(status);
		return status;
	}

	@RequestMapping(value = "", method = RequestMethod.DELETE)
	public Teacher delete(@RequestBody Teacher student, HttpServletRequest request, HttpServletResponse response) {
		Teacher status = teacherAppService.deleteTeacher(student);
		return status;
	}
	
	@RequestMapping(value = "", method = RequestMethod.PUT)
	public Teacher update(@RequestBody Teacher student) {
		Teacher status = teacherAppService.addTeacher(student);
		return status;
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<Teacher> get() {
		List<Teacher> students = teacherAppService.getTeachers();
		return students;

	}
}
