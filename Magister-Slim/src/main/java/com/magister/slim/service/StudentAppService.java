package com.magister.slim.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.magister.slim.entity.Student;
import com.magister.slim.entity.User;
import com.magister.slim.entity.User.role;
import com.magister.slim.repository.StudentInterface;

@Service
public class StudentAppService {
	
	@Autowired
	StudentInterface studentInterface;
	@Autowired
	UserAppService userAppService;
	
	public Student deleteStudent(int studentId)
	{
		if(studentInterface.findById(studentId).isPresent())
		{
		Student student=studentInterface.findById(studentId).get();
		student.setActive(false);
		studentInterface.save(student);
		return student;
		}
		else
			return null;
	}
	public List<Student> getStudents(String studentName)
	{
		List<Student> student1=studentInterface.findAll();
		return student1;
	}
	public Student getStudent(int studentid) {
		Student student=studentInterface.findById(studentid).get();
		return student;
	}
	public Student addStudentDetails(Student studentDetails) {
		
		return studentInterface.save(studentDetails);
	}
	public Student updateStudentName(Student student) {
		// TODO Auto-generated method stub
		return null;
	}
}
