package com.magister.slim.restcontroller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.magister.slim.entity.Unit;
import com.magister.slim.references.StudyGuideReference;
import com.magister.slim.service.UnitAppService;

@RestController
@RequestMapping("studyguide/theme/units")
@CrossOrigin(origins = "http://localhost:4200")
public class UnitController {

	@Autowired
	UnitAppService unitAppService;

	@RequestMapping(value = "", method = RequestMethod.POST)
	public Unit add(@RequestBody Unit unit) {
		StudyGuideReference studyGuideReference= new StudyGuideReference();
		//studyGuideReference.setStudyGuideId(studyGuideId);
		unit.setStudyGuideReference(studyGuideReference);
		Unit status = unitAppService.addUnit(unit);
		System.out.println(status);
		return status;
	}

	@RequestMapping(value = "", method = RequestMethod.DELETE)
	public Unit delete(@RequestBody Unit unit, HttpServletRequest request, HttpServletResponse response) {
		Unit status = unitAppService.deleteUnit(unit);
		return status;
	}
	
	@RequestMapping(value = "", method = RequestMethod.PUT)
	public Unit update(@RequestBody Unit unit) {
		Unit status = unitAppService.addUnit(unit);
		return status;
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<Unit> get() {
		List<Unit> courses = unitAppService.getUnits();
		return courses;

	}

}
