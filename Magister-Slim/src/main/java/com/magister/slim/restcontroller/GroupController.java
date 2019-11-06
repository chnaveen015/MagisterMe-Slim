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
import com.magister.slim.entity.Group;
import com.magister.slim.references.TeacherReference;
import com.magister.slim.service.GroupAppService;

@RestController
@RequestMapping("offering/offering-level/group")
@CrossOrigin(origins = "http://localhost:4200")
public class GroupController {

	@Autowired
	GroupAppService groupAppService;

	@RequestMapping(value = "", method = RequestMethod.POST)
	public Group add(@RequestBody Group group, HttpServletRequest request, HttpServletResponse response) {
		TeacherReference teacher = new TeacherReference();
		Group status = groupAppService.addGroup(group, teacher, null, null, null);
		System.out.println(status);
		return status;
	}

	@RequestMapping(value = "", method = RequestMethod.PUT)
	public Group update(@RequestBody Group group, HttpServletRequest request, HttpServletResponse response) {
		group.setActive(true);
		TeacherReference teacher = new TeacherReference();
		Group status = groupAppService.addGroup(group, teacher, null, null, null);
		System.out.println(status);
		return status;
	}

	@RequestMapping(value = "", method = RequestMethod.DELETE)
	public Group delete(@RequestBody Group group, HttpServletRequest request, HttpServletResponse response) {
		Group status = groupAppService.deleteGroup(group);
		return status;
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<Group> get() {
		List<Group> groups = groupAppService.getGroups();
		return groups;

	}
}
