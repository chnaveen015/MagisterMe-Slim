package com.magister.slim.restcontroller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.magister.slim.entity.StudyGuide;
import com.magister.slim.entity.Theme;
import com.magister.slim.references.StudyGuideReference;
import com.magister.slim.service.ThemeAppService;

@RestController
@RequestMapping("studyguide/themes")
@CrossOrigin(origins = "http://localhost:4200")
public class ThemeController {

	@Autowired
	ThemeAppService themeAppService;

	@RequestMapping(value = "", method = RequestMethod.POST)
	public Theme add(@RequestBody Theme theme,HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		StudyGuide studyGuide =(StudyGuide) session.getAttribute("studyGuide");
		StudyGuideReference studyGuideReference=new StudyGuideReference();
		studyGuideReference.setStudyGuideId(studyGuide.getStudyGuideIdId());
		studyGuideReference.setStudyGuideName(studyGuide.getStudyGuideName());
		Theme status = themeAppService.addTheme(theme,studyGuideReference);
		System.out.println(status);
		return status;
	}
	
	@RequestMapping(value = "", method = RequestMethod.PUT)
	public Theme update(@RequestBody Theme theme,HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		StudyGuide studyGuide =(StudyGuide) session.getAttribute("studyGuide");
		StudyGuideReference studyGuideReference=new StudyGuideReference();
		studyGuideReference.setStudyGuideId(studyGuide.getStudyGuideIdId());
		studyGuideReference.setStudyGuideName(studyGuide.getStudyGuideName());
		Theme status = themeAppService.addTheme(theme,studyGuideReference);
		System.out.println(status);
		return status;
	}

	@RequestMapping(value = "", method = RequestMethod.DELETE)
	public Theme delete(@RequestBody Theme unit, HttpServletRequest request, HttpServletResponse response) {
		Theme status = themeAppService.deleteTheme(unit);
		return status;
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<Theme> get() {
		List<Theme> courses = themeAppService.getThemes();
		return courses;

	}

}
