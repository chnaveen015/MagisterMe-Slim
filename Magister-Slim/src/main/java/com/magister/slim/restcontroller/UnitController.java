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
import com.magister.slim.entity.Unit;
import com.magister.slim.references.StudyGuideReference;
import com.magister.slim.references.ThemeReference;
import com.magister.slim.service.UnitAppService;

@RestController
@RequestMapping("studyguide/{studyGuideId}/theme/{themeId}/unit")
@CrossOrigin(origins = "http://localhost:4200")
public class UnitController {

	@Autowired
	UnitAppService unitAppService;

	StudyGuideReference studyGuideReference = new StudyGuideReference();
	ThemeReference themeReference = new ThemeReference();

	@RequestMapping(value = "", method = RequestMethod.POST)
	public Unit add(@RequestBody Unit unit, @PathVariable("studyGuideId") int studyGuideId,
			@PathVariable("themeId") int themeId) {
		studyGuideReference.setStudyGuideId(studyGuideId);
		themeReference.setThemeId(themeId);
		unit.setStudyGuideReference(studyGuideReference);
		Unit status = unitAppService.addUnit(unit);
		System.out.println(status);
		return status;
	}

	@RequestMapping(value = "/{unitId}", method = RequestMethod.DELETE)
	public int delete(@PathVariable("unitId") int unitId, @PathVariable("studyGuideId") int studyGuideId,
			@PathVariable("themeId") int themeId) {
		studyGuideReference.setStudyGuideId(studyGuideId);
		themeReference.setThemeId(themeId);
		int status = unitAppService.deleteUnit(unitId);
		return status;
	}

	@RequestMapping(value = "/{unitId}", method = RequestMethod.PUT)
	public Unit update(@PathVariable("unitId") int unitId, @PathVariable("studyGuideId") int studyGuideId,
			@PathVariable("themeId") int themeId, @RequestBody Unit unit) {
		studyGuideReference.setStudyGuideId(studyGuideId);
		themeReference.setThemeId(themeId);
		unit.setUnitId(unitId);
		Unit status = unitAppService.addUnit(unit);
		return status;
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public Unit get(@RequestParam int unitId) {
		Unit unit = unitAppService.getUnit(unitId);
		return unit;
	}

	@RequestMapping(value = "/{unitName}", method = RequestMethod.GET)
	public List<Unit> get(@PathVariable("unitName") String unitName) {
		List<Unit> units = unitAppService.getUnits(unitName);
		return units;
	}

}
