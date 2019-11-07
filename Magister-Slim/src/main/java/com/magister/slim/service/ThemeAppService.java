package com.magister.slim.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.magister.slim.entity.StudyGuide;
import com.magister.slim.entity.Theme;
import com.magister.slim.references.ThemeReference;
import com.magister.slim.repository.StudyGuideInterface;
import com.magister.slim.repository.ThemeInterface;

@Service
public class ThemeAppService {

	@Autowired
	StudyGuideInterface studyGuideInterface;
	@Autowired
	ThemeInterface themeInterface;
	@Autowired
	StudyGuideAppService studyGuideAppService;

	public List<Theme> getThemes(String themeName, int studyGuideId) {
		List<Theme> themes = themeInterface.getThemes(themeName);
		List<Theme> themeReferences = themes.stream().map(themeReference -> {
			if (themeReference.getStudyGuideReference().getStudyGuideId() == studyGuideId) {
				return themeReference;
			} else
				return null;
		}).collect(Collectors.toList());
		return themeReferences;
	}

	public int deleteTheme(int themeId, int studyGuideId) {
		Theme theme = themeInterface.findById(themeId).get();
		theme.setActive(false);
		themeInterface.save(theme);
		studyGuideAppService.deleteThemeReference(themeId, studyGuideId);
		return themeId;
	}

	public Theme addTheme(Theme theme, StudyGuide studyGuide) {
		themeInterface.save(theme);
		studyGuide.setThemes(themeDetails(theme.getThemeId(), theme.getThemeName(), studyGuide));
		studyGuideInterface.save(studyGuide);
		return theme;
	}

	public Theme updateTheme(Theme theme, StudyGuide studyGuide) {
		themeInterface.save(theme);
		studyGuideInterface.save(studyGuide);
		return theme;
	}

	public List<ThemeReference> themeDetails(int id, String themeName, StudyGuide studyGuide) {
		ThemeReference themeReference = new ThemeReference();
		List<ThemeReference> themes = new ArrayList<ThemeReference>();
		themes = studyGuide.getThemes();
		if (themes == null)
			themes = new ArrayList<ThemeReference>();
		themeReference.setThemeId(id);
		themeReference.setThemeName(themeName);
		themeReference.setActive(true);
		themes.add(themeReference);
		return themes;
	}

	public Theme getTheme(int themeid, int studyGuideId) {
		if (themeInterface.findById(themeid).isPresent()) {
			Theme theme = themeInterface.findById(themeid).get();
			if (theme.getStudyGuideReference().getStudyGuideId() == studyGuideId)
				return theme;
			else
				return null;
		} else
			return null;
	}
}
