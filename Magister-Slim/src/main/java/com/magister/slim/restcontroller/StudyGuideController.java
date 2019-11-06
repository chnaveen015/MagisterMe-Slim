package com.magister.slim.restcontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.magister.slim.entity.StudyGuide;
import com.magister.slim.service.StudyGuideAppService;

@RestController
@RequestMapping("studyGuide")
//@CrossOrigin(origins = "http://localhost:4200")
public class StudyGuideController {

	@Autowired
	StudyGuideAppService studyGuideAppService;

	@RequestMapping(value = "", method = RequestMethod.POST)
	public StudyGuide add(@RequestBody StudyGuide studyGuide) {
		StudyGuide status = studyGuideAppService.addStudyGuide(studyGuide);
		return status;
	}

	@RequestMapping(value="{studyGuideId}",method = RequestMethod.DELETE)
	public int delete(@PathVariable("studyGuideId") int studyGuideId, HttpServletRequest request,
			HttpServletResponse response) {
		int status = studyGuideAppService.deleteStudyGuide(studyGuideId);
		return status;
	}
	
	@RequestMapping(value = "", method = RequestMethod.PUT)
	public StudyGuide update(@RequestBody StudyGuide studyGuide) {
		StudyGuide status = studyGuideAppService.addStudyGuide(studyGuide);
		return status;
	}

	@RequestMapping(method = RequestMethod.GET)
	public StudyGuide get(@RequestParam int studyGuideId) {
		StudyGuide studyGuide = studyGuideAppService.getStudyGuide(studyGuideId);
		return studyGuide;

	}
}
