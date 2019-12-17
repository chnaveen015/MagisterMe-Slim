package com.magister.slim.restcontroller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.magister.slim.entity.StudyGuide;
import com.magister.slim.entity.User;
import com.magister.slim.service.StudyGuideAppService;

@RestController
@RequestMapping("studyGuide")
@CrossOrigin(origins = "http://localhost:4200")
public class StudyGuideController {

	@Autowired
	StudyGuideAppService studyGuideAppService;

	@RequestMapping(method = RequestMethod.POST)
	public StudyGuide createStudyGuide(@RequestBody StudyGuide studyGuide,HttpServletRequest request) {
		studyGuide.setActive(true);
		User user= (User) request.getServletContext().getAttribute("user");
		StudyGuide status = studyGuideAppService.addStudyGuide(studyGuide,user);
		return status;
	}

	@RequestMapping(value = "/{studyGuideId}", method = RequestMethod.DELETE)
	public String deleteStudyGuideDetails(@PathVariable("studyGuideId") String studyGuideId, HttpServletRequest request,
			HttpServletResponse response) {
		String status = studyGuideAppService.deleteStudyGuide(studyGuideId);
		return status;
	}

	@RequestMapping(value = "/{studyGuideId}", method = RequestMethod.PUT)
	public StudyGuide updateStudyGuideDetails(@PathVariable("studyGuideId") String studyGuideId, @RequestBody StudyGuide studyGuide) {
		StudyGuide status = studyGuideAppService.updateStudyGuide(studyGuide,studyGuideId);
		return status;
	}

	@RequestMapping(value = "/{studyGuideId}",method = RequestMethod.GET)
	public StudyGuide getStudyGuideDetail(@PathVariable("studyGuideId") String studyGuideId) {
		StudyGuide studyGuide = studyGuideAppService.getStudyGuideById(studyGuideId);
		return studyGuide;
	}

//	@RequestMapping(method = RequestMethod.GET)
//	public List<StudyGuide> getStudyGuideDetails(@RequestParam String studyGuideName,HttpServletRequest request) {
//		User user= (User) request.getServletContext().getAttribute("user");
//		System.out.println(user);
//		List<StudyGuide> studyGuide = studyGuideAppService.getStudyGuide(studyGuideName);
//		return studyGuide;
//	}
	@RequestMapping(method = RequestMethod.GET)
	public List<StudyGuide> getStudyGuide(HttpServletRequest request) {
		User user= (User) request.getServletContext().getAttribute("user");
		List<StudyGuide> studyGuide = studyGuideAppService.getStudyGuide(user);
		return studyGuide;
	}
}
