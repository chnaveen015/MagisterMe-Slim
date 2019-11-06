package com.magister.slim.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.magister.slim.entity.Theme;
import com.magister.slim.references.StudyGuideReference;
import com.magister.slim.repository.ThemeInterface;

@Service
public class ThemeAppService {
	
	@Autowired
	ThemeInterface themeInterface;
	
	public List<Theme> getThemes()
	{
		List<Theme> themes=themeInterface.findAll();
		return themes;
	}
	public Theme deleteTheme(Theme theme)
	{
		themeInterface.deleteById(theme.getThemeId());
		return theme;
	}
	
	public Theme addTheme(Theme theme,StudyGuideReference studyGuide)
	{
		theme.setActive(true);
		theme.setThemeId(theme.getThemeId());
		theme.setThemeName("Theme1");
		theme.setUnits(theme.getUnits());
		theme.setStudyGuideReference(studyGuide);
		themeInterface.save(theme);
		return theme;
	}
	public Theme addTheme(Theme theme)
	{
		theme.setActive(true);
		theme.setThemeId(theme.getThemeId());
		theme.setThemeName("Theme1");
		theme.setUnits(theme.getUnits());
		themeInterface.save(theme);
		return theme;
	}
	public Theme getTheme(int themeid) {
		Theme theme=themeInterface.findById(themeid).get();
		return theme;
	}

}
