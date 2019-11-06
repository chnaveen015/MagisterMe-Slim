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
import com.magister.slim.entity.Resource;
import com.magister.slim.references.TeacherReference;
import com.magister.slim.service.ResourceAppService;

@RestController
@RequestMapping("studyguide/theme/unit")
@CrossOrigin(origins = "http://localhost:4200")
public class ResourceController {

	@Autowired
	ResourceAppService resourceAppService;

	@RequestMapping(value = "/resource", method = RequestMethod.POST)
	public Resource add(@RequestBody Resource resource, HttpServletRequest request, HttpServletResponse response) {
		resource.setActive(true);
		TeacherReference teacher = new TeacherReference();
		Resource status = resourceAppService.addResource(resource, teacher);
		System.out.println(status);
		return status;
	}

	@RequestMapping(value = "/resource", method = RequestMethod.PUT)
	public Resource update(@RequestBody Resource resource) {
		resource.setActive(true);
		TeacherReference teacher = new TeacherReference();
		Resource status = resourceAppService.addResource(resource, teacher);
		System.out.println(status);
		return status;
	}

	@RequestMapping(value = "/resource", method = RequestMethod.DELETE)
	public Resource delete(@RequestBody Resource resource, HttpServletRequest request, HttpServletResponse response) {
		Resource status = resourceAppService.deleteResource(resource);
		return status;
	}

//	@RequestMapping(value = "/resources", method = RequestMethod.GET)
//	public List<Resource> get() {
//		List<Resource> resources = resourceAppService.getResources();
//		return resources;
//
//	}
	
	@RequestMapping(value = "/resource", method = RequestMethod.GET)
	public Resource getResource(@RequestParam int resourceid) {
		Resource resource = resourceAppService.getResource(resourceid);
		return resource;

	}
}
