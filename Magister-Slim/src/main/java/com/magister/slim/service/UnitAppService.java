package com.magister.slim.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.magister.slim.entity.StudyGuide;
import com.magister.slim.entity.Theme;
import com.magister.slim.entity.Unit;
import com.magister.slim.references.UnitReference;
import com.magister.slim.repository.StudyGuideInterface;
import com.magister.slim.repository.ThemeInterface;
import com.magister.slim.repository.UnitInterface;

@Service
public class UnitAppService {

	@Autowired
	UnitInterface unitInterface;
	@Autowired
	ThemeInterface themeInterface;
	@Autowired
	StudyGuideInterface studyGuideInterface;
	@Autowired
	UnitAppService unitAppService;

	public Unit getUnit(int unitid, int themeId, int studyGuideId) {
		if (unitInterface.findById(unitid).isPresent()) {
			Unit unit = unitInterface.findById(unitid).get();
			if (unit.getStudyGuideReference().getStudyGuideId() == studyGuideId
					&& unit.getThemeReference().getThemeId() == themeId) {
				return unit;
			} else
				return null;
		} else
			return null;
	}

	public List<Unit> getUnits(String unitName, int themeId, int studyGuideId) {
		List<Unit> units = unitInterface.getUnits(unitName);
		List<Unit> unitReferences = units.stream().map(unitReference -> {
			if (unitReference.getStudyGuideReference().getStudyGuideId() == studyGuideId
					&& unitReference.getThemeReference().getThemeId() == themeId) {
				return unitReference;
			} else
				return null;
		}).collect(Collectors.toList());
		return unitReferences;
	}

	public int deleteUnit(int unitId) {
//		Unit unit = unitInterface.findById(unitId).get();
//		Theme theme = themeInterface.findById(unit.getThemeReference().getThemeId()).get();
//		StudyGuide studyGuide = studyGuideInterface.findById(unit.getStudyGuideReference().getStudyGuideId()).get();
//		theme.getUnits().remove(unitId);
//		studyGuide.getUnits().remove(unitId);
		unitInterface.deleteById(unitId);
		return unitId;
	}

	public Unit updateUnit(Unit unit ,Theme theme,StudyGuide studyGuide) {
		themeInterface.save(theme);
		studyGuideInterface.save(studyGuide);
		unitInterface.save(unit);
		return unit;
	}

	public Unit addUnit(Unit unit) {
		unitInterface.save(unit);
		StudyGuide studyGuide = studyGuideInterface.findById(unit.getStudyGuideReference().getStudyGuideId()).get();
		Theme theme = themeInterface.findById(unit.getThemeReference().getThemeId()).get();
		studyGuide.setUnits(unitDetails(unit.getUnitId(), unit.getUnitName(), studyGuide));
		theme.setUnits(unitDetails(unit.getUnitId(), unit.getUnitName(), theme));
		themeInterface.save(theme);
		studyGuideInterface.save(studyGuide);
		return unit;
	}

	public List<UnitReference> unitDetails(int unitId, String unitName, Theme theme) {
		UnitReference unitReference = new UnitReference();
		List<UnitReference> units = new ArrayList<UnitReference>();
		units = theme.getUnits();
		if (units == null)
			units = new ArrayList<UnitReference>();
		unitReference.setUnitId(unitId);
		unitReference.setUnitName(unitName);
		unitReference.setActive(true);
		units.add(unitReference);
		return units;
	}

	public List<UnitReference> unitDetails(int unitId, String unitName, StudyGuide studyGuide) {
		UnitReference unitReference = new UnitReference();
		List<UnitReference> units = new ArrayList<UnitReference>();
		units = studyGuide.getUnits();
		if (units == null)
			units = new ArrayList<UnitReference>();
		unitReference.setUnitId(unitId);
		unitReference.setUnitName(unitName);
		unitReference.setActive(true);
		units.add(unitReference);
		return units;
	}
//	public StudyGuideReference studyGuideDetails(int id ,String studyGuideName)
//	{
//		StudyGuideReference studyGuideReference=new StudyGuideReference();
//		studyGuideReference.setStudyGuideId(id);
//		studyGuideReference.setStudyGuideName(studyGuideName);
//		return studyGuideReference;
//	}
//	public ThemeReference themeDetails(int id ,String themeName)
//	{
//		ThemeReference themeReference=new ThemeReference();
//		themeReference.setThemeId(id);
//		themeReference.setThemeName(themeName);
//		return themeReference;
//	}
//	public List<ResourceReference> resourceDetails(int id,String resourceName)
//	{
//		ResourceReference resourceReference=new ResourceReference();
//		List<ResourceReference> resources=new ArrayList<ResourceReference>();
//		resourceReference.setResourceId(id);
//		resourceReference.setResourceName(resourceName);
//		resources.add(resourceReference);
//		return resources;
//	}
//	public List<AssignmentReference> assignmentDetails(int id,String assignmentName)
//	{
//		AssignmentReference assignmentReference=new AssignmentReference();
//		List<AssignmentReference> assignments=new ArrayList<AssignmentReference>();
//		assignmentReference.setAssignmentId(id);
//		assignmentReference.setAssignmentName(assignmentName);
//		assignments.add(assignmentReference);
//		return assignments;
//	}
}
