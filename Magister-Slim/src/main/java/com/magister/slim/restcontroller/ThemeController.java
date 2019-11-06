package com.magister.slim.restcontroller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.magister.slim.entity.Theme;
import com.magister.slim.references.StudyGuideReference;
import com.magister.slim.service.ThemeAppService;

@RestController
@RequestMapping("studyguide/{studyGuideId}/themes")
@CrossOrigin(origins = "http://localhost:4200")
public class ThemeController {

	@Autowired
	ThemeAppService themeAppService;

	@RequestMapping(value = "", method = RequestMethod.POST)
	public Theme add(@RequestBody Theme theme, @PathVariable("studyGuideId") int studyGuideId) {
		StudyGuideReference studyGuideReference = new StudyGuideReference();
		studyGuideReference.setStudyGuideId(studyGuideId);
		theme.setStudyGuideReference(studyGuideReference);
		Theme status = themeAppService.addTheme(theme);
		System.out.println(status);
		return status;
	}

	@RequestMapping(value = "/{themeId}", method = RequestMethod.PUT)
	public Theme update(@PathVariable("themeId") int themeId, @RequestBody Theme theme) {
		theme.setThemeId(themeId);
		Theme status = themeAppService.addTheme(theme);
		System.out.println(status);
		return status;
	}

	@RequestMapping(value = "/{themeId}", method = RequestMethod.DELETE)
	public int delete(@PathVariable("themeId") int themeId) {
		int status = themeAppService.deleteTheme(themeId);
		return status;
	}

	@RequestMapping(method = RequestMethod.GET)
	public Theme get(@RequestParam int themeId) {
		Theme theme = themeAppService.getTheme(themeId);
		return theme;

	}

	@RequestMapping(value = "/{themeName}", method = RequestMethod.GET)
	public List<Theme> get(@PathVariable("themeName") String themeName) {
		List<Theme> themes = themeAppService.getThemes(themeName);
		return themes;

	}

}
