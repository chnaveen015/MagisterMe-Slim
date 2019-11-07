package com.magister.slim.restcontroller;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.magister.slim.entity.StudyGuide;
import com.magister.slim.entity.Theme;
import com.magister.slim.entity.Unit;
import com.magister.slim.references.StudyGuideReference;
import com.magister.slim.references.UnitReference;
import com.magister.slim.repository.StudyGuideInterface;
import com.magister.slim.repository.ThemeInterface;
import com.magister.slim.repository.UnitInterface;
import com.magister.slim.service.ThemeAppService;

@RestController
@RequestMapping("studyGuide/{studyGuideId}/theme")
//@CrossOrigin(origins = "http://localhost:4200")
public class ThemeController {

	@Autowired
	StudyGuideInterface studyGuideInterface;
	@Autowired
	ThemeAppService themeAppService;
	@Autowired
	ThemeInterface themeInterface;
	@Autowired
	UnitInterface unitInterface;

	StudyGuideReference studyGuideReference = new StudyGuideReference();
	StudyGuide studyGuide = new StudyGuide();

	@RequestMapping(method = RequestMethod.POST)
	public Theme createTheme(@RequestBody Theme theme, @PathVariable("studyGuideId") int studyGuideId) {
		studyGuideReference.setStudyGuideId(studyGuideId);
		if (studyGuideInterface.findById(studyGuideId).isPresent()) {
			studyGuide = studyGuideInterface.findById(studyGuideId).get();
			studyGuideReference.setStudyGuideName(studyGuide.getStudyGuideName());
			studyGuideReference.setActive(studyGuide.isActive());
			theme.setStudyGuideReference(studyGuideReference);
			Theme status = themeAppService.addTheme(theme, studyGuide);
			System.out.println(status);
			return status;
		} else
			return null;
	}

	@RequestMapping(value = "/{themeId}", method = RequestMethod.PUT)
	public Theme updateThemeDetails(@PathVariable("themeId") int themeId, @RequestBody Theme theme,
			@PathVariable("studyGuideId") int studyGuideId) {
		String themeName = theme.getThemeName();
		theme = themeInterface.findById(themeId).get();
		if (theme.getUnits() != null) {
			List<UnitReference> unitReferences = theme.getUnits().stream().map(unitReference -> {
				Unit unit = unitInterface.findById(unitReference.getUnitId()).get();
				unit.getThemeReference().setThemeName(themeName);
				unitInterface.save(unit);
				return unitReference;
			}).collect(Collectors.toList());
			theme.setUnits(unitReferences);
		}
		studyGuide = studyGuideInterface.findById(studyGuideId).get();
		studyGuide.getThemes().stream().filter((studyGuideReference) -> studyGuideReference.getThemeId() == themeId)
				.findAny().get().setThemeName(themeName);
		theme.setThemeName(themeName);
		return themeAppService.updateTheme(theme, studyGuide);
	}

	@RequestMapping(value = "/{themeId}", method = RequestMethod.DELETE)
	public int deleteThemeDetails(@PathVariable("themeId") int themeId,
			@PathVariable("studyGuideId") int studyGuideId) {
		int status = themeAppService.deleteTheme(themeId, studyGuideId);
		return status;
	}

	@RequestMapping(value = "/{themeId}", method = RequestMethod.GET)
	public Theme getThemeDetail(@PathVariable("themeId") int themeId, @PathVariable("studyGuideId") int studyGuideId) {
		Theme theme = themeAppService.getTheme(themeId, studyGuideId);
		return theme;

	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Theme> getThemeDetails(@RequestParam String themeName, @PathVariable("studyGuideId") int studyGuideId) {
		List<Theme> themes = themeAppService.getThemes(themeName, studyGuideId);
		return themes;
	}

}
