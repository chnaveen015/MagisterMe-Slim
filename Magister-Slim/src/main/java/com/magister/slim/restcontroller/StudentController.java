package com.magister.slim.restcontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.magister.slim.entity.Student;
import com.magister.slim.entity.Teacher;
import com.magister.slim.service.StudentAppService;

@RestController
@RequestMapping("group/{groupId}/student")
@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {

	@Autowired
	StudentAppService studentAppService;

	@RequestMapping(method = RequestMethod.POST)
	public Student addStudent(@RequestBody Student studentDetails) {
		Student status = studentAppService.addStudentDetails(studentDetails);
		return status;
	}

	@RequestMapping(path="{studentId}",method = RequestMethod.DELETE)
	public Student deleteStudentDetails(@RequestParam("studentId") int studentId) {
		Student status = studentAppService.deleteStudent(studentId);
		return status;
	}

	@RequestMapping(path="{studentId}",method = RequestMethod.PUT)
	public Student updateStudentDetails(@RequestParam("studentId") int studentId,@RequestBody Student student) {
		student.setStudentId(studentId);
		Student status = studentAppService.updateStudentName(student);
		return null;
	}

	@RequestMapping(value = "/students", method = RequestMethod.GET)
	public Student getStudentDetails(@RequestParam int studentid) {
		Student student = studentAppService.getStudent(studentid);
		return student;

	}

}
