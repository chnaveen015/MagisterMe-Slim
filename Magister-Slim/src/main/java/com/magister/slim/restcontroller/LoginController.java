package com.magister.slim.restcontroller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.magister.slim.entity.User;
import com.magister.slim.service.LoginAppService;

@RestController
@RequestMapping("user-validate")
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {

	@Autowired
	LoginAppService loginAppService;

	@RequestMapping(value = "", method = RequestMethod.POST)
	public User insert(@RequestBody User user, HttpServletRequest request) {
		user.setActive(true);
		User status = loginAppService.loginValidation(user);
		request.getServletContext().setAttribute("user", user);
		System.out.println(request.getServletContext().getAttribute("user"));
		System.out.println(status);
		return status;
	}
}
