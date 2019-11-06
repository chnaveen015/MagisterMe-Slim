package com.magister.slim.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.magister.slim.entity.Theme;
import com.magister.slim.entity.Unit;
import com.magister.slim.references.AssignmentReference;
import com.magister.slim.references.ResourceReference;
import com.magister.slim.references.StudyGuideReference;
import com.magister.slim.references.ThemeReference;
import com.magister.slim.references.UnitReference;
import com.magister.slim.repository.UnitInterface;

@Service
public class UnitAppService {
	
	@Autowired
	UnitInterface unitInterface;
	@Autowired
	ThemeAppService themeAppService;
	
	public Unit getUnit(int unitid) {
		Unit unit=unitInterface.findById(unitid).get();
		return unit;
	}
	
	public List<Unit> getUnits()
	{
		List<Unit> units=unitInterface.findAll();
		return units;
	}
	public Unit deleteUnit(Unit unit)
	{
		unitInterface.deleteById(unit.getUnitId());
		return unit;
	}
	public Unit addUnit(Unit unit)
	{
		Theme theme = new Theme();
		unit.setAssignments(assignmentDetails(181,"Assignment1"));
		unit.setResources(resourceDetails(191,"Resource1"));
		unitInterface.save(unit);
		theme.setThemeId(theme.getThemeId());
		theme.setUnits(unitDetails(unit.getUnitId(), unit.getUnitName()));
		themeAppService.addTheme(theme);
		return unit;
	}
	public List<UnitReference> unitDetails(int id,String unitName)
	{
		UnitReference unitReference=new UnitReference();
		List<UnitReference> units=new ArrayList<UnitReference>();
		unitReference.setUnitId(id);
		unitReference.setUnitName(unitName);
		units.add(unitReference);
		return units;
	}
	public StudyGuideReference studyGuideDetails(int id ,String studyGuideName)
	{
		StudyGuideReference studyGuideReference=new StudyGuideReference();
		studyGuideReference.setStudyGuideId(id);
		studyGuideReference.setStudyGuideName(studyGuideName);
		return studyGuideReference;
	}
	public ThemeReference themeDetails(int id ,String themeName)
	{
		ThemeReference themeReference=new ThemeReference();
		themeReference.setThemeId(id);
		themeReference.setThemeName(themeName);
		return themeReference;
	}
	public List<ResourceReference> resourceDetails(int id,String resourceName)
	{
		ResourceReference resourceReference=new ResourceReference();
		List<ResourceReference> resources=new ArrayList<ResourceReference>();
		resourceReference.setResourceId(id);
		resourceReference.setResourceName(resourceName);
		resources.add(resourceReference);
		return resources;
	}
	public List<AssignmentReference> assignmentDetails(int id,String assignmentName)
	{
		AssignmentReference assignmentReference=new AssignmentReference();
		List<AssignmentReference> assignments=new ArrayList<AssignmentReference>();
		assignmentReference.setAssignmentId(id);
		assignmentReference.setAssignmentName(assignmentName);
		assignments.add(assignmentReference);
		return assignments;
	}
}
