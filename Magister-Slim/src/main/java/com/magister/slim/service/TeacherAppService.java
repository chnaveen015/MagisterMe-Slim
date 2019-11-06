package com.magister.slim.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.magister.slim.entity.Teacher;
import com.magister.slim.entity.User;
import com.magister.slim.entity.User.role;
import com.magister.slim.repository.TeacherInterface;

@Service
public class TeacherAppService {
	
	@Autowired
	TeacherInterface teacherInterface;
	@Autowired
	UserAppService userAppService;
	
	public List<Teacher> getTeachers()
	{
		List<Teacher> teachers=teacherInterface.findAll();
		return teachers;
	}
	public Teacher deleteTeacher(Teacher teacher)
	{
		teacherInterface.deleteById(teacher.getTeacherid());
		return teacher;
	}
	public Teacher addTeacher(Teacher teacher)
	{
		User user=new User();
		teacher.setActive(true);
		teacher.setAddress("Hyderabad");
		teacher.setAge(36);
		teacher.setGender("male");
		teacher.setName("Tom");
		teacher.setPhoneno(536788699);
		teacher.setTeacherid(4);
		user.setUserid(teacher.getTeacherid());
		user.setUsername(teacher.getName());
		user.setUserType(role.teacher);
		teacher.setUserReference(user);
		teacher.setGroupReference(teacher.getGroupReference());
		userAppService.addUser(user);
		return teacherInterface.save(teacher);
	}
	public Teacher getTeacher(int teacherid) {
		Teacher teacher=teacherInterface.findById(teacherid).get();
		return teacher;
	}
}
