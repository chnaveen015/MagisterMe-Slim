package com.magister.slim.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.magister.slim.entity.User;
import com.magister.slim.entity.User.role;
import com.magister.slim.repository.StudentInterface;
import com.magister.slim.repository.UserInterface;

@Service
public class LoginAppService {
	
	@Autowired
	UserInterface userInterface;
	
	@Autowired
	StudentInterface studentInterface;

	@SuppressWarnings("static-access")
	public User loginValidation(User user) {
		role role = null;
		ArrayList<User> users = (ArrayList<User>) userInterface.findAll();
		System.out.println(users);
		users.stream().filter(userdata ->userdata.getUsername().equals(user.getUsername())
				&& userdata.getPassword().equals(user.getPassword())).forEach(userdata ->{if (userdata.getRole().equals(role.teacher))user.setUserType(role.teacher);
				  else if(userdata.getRole().equals(role.student)) user.setUserType(role.student); else user.setUserType(role.teacher);
					});
		return user;
	}

}