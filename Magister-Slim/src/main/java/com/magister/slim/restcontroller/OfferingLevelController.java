package com.magister.slim.restcontroller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.Soundbank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.magister.slim.entity.Offering;
import com.magister.slim.entity.OfferingLevel;
import com.magister.slim.references.OfferingReference;
import com.magister.slim.service.OfferingAppService;
import com.magister.slim.service.OfferingLevelAppService;

@RestController
@RequestMapping("offering/{offeringId}/offering-level")
//@CrossOrigin(origins = "http://localhost:4200")
public class OfferingLevelController {

	@Autowired
	OfferingLevelAppService offeringLevelAppService;
	@Autowired
	OfferingAppService offeringAppService;

	@PostMapping(value = "")
	public OfferingLevel createOfferingLevel(@PathVariable("offeringId") String offeringId,
			@RequestBody OfferingLevel offeringLevel) {
		Offering offering = offeringAppService.getOfferingById(offeringId);
		if (offering != null) {
			offeringLevel.setOfferingReference(
					new OfferingReference(offering.getOfferingid(), offering.getOfferingName(), true));
			OfferingLevel status = offeringLevelAppService.addOfferingLevel(offeringLevel);
			return status;
		} else
			return null;
	}

	@DeleteMapping(value = "{offeringLevelId}")
	public OfferingLevel deleteOfferingLevel(@PathVariable("offeringId") String offeringId,
			@PathVariable("offeringLevelId") String offeringLevelId) {
		OfferingLevel status = offeringLevelAppService.deleteOfferingLevel(offeringId, offeringLevelId);
		return status;
	}

	@PutMapping(value = "{offeringLevelId}")
	public OfferingLevel updateOfferingLevel(@PathVariable("offeringId") String offeringId,
			@PathVariable("offeringLevelId") String offeringLevelId, @RequestBody OfferingLevel offeringLevel) {
		offeringLevel.setOfferingLevelId(offeringLevelId);
		offeringLevel.setOfferingReference(new OfferingReference());
		offeringLevel.getOfferingReference().setOfferingId(offeringId);
		OfferingLevel status = offeringLevelAppService.updateOfferingLevelDetails(offeringLevel);
		return status;
	}

	@GetMapping(value = "{offeringLevelId}")
	public OfferingLevel getOfferingLevelDetails(@PathVariable("offeringId") String offeringId,
			@PathVariable("offeringLevelId") String offeringLevelId) {
		OfferingLevel offeringLevel = offeringLevelAppService.getOfferingLevelById(offeringId, offeringLevelId);
		return offeringLevel;
	}

	@GetMapping()
	public OfferingLevel getOfferingLevelByName(@PathVariable("offeringId") String offeringId,
			@RequestParam("offeringLevelName") String offeringLevelName) {
		return offeringLevelAppService.getOfferingLevelByName(offeringId, offeringLevelName);

	}

}
