package com.magister.slim.restcontroller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.magister.slim.entity.OfferingLevel;
import com.magister.slim.service.OfferingLevelAppService;

@RestController
@RequestMapping("offering/offering-level")
//@CrossOrigin(origins = "http://localhost:4200")
public class OfferingLevelController {

	@Autowired
	OfferingLevelAppService offeringLevelAppService;

	@PostMapping(value = "")
	public OfferingLevel add(@RequestBody OfferingLevel offeringLevel) {
		OfferingLevel status = offeringLevelAppService.addOfferingLevel(offeringLevel);
		System.out.println(status);
		return status;
	}

	@DeleteMapping(value = "")
	public OfferingLevel delete(@RequestBody OfferingLevel offeringLevel, HttpServletRequest request,
			HttpServletResponse response) {
		OfferingLevel status = offeringLevelAppService.deleteOfferingLevel(offeringLevel);
		return status;
	}

	@PutMapping(value = "")
	public OfferingLevel update(@RequestBody OfferingLevel offeringLevel, HttpServletRequest request,
			HttpServletResponse response) {
		OfferingLevel status = offeringLevelAppService.addOfferingLevel(offeringLevel);
		System.out.println(status);
		return status;
	}

	@GetMapping(value = "")
	public List<OfferingLevel> get() {
		List<OfferingLevel> offeringLevels = offeringLevelAppService.getOfferingLevels();
		return offeringLevels;

	}

}
