package com.magister.slim.restcontroller;

import java.util.List; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.magister.slim.entity.Offering;
import com.magister.slim.service.OfferingAppService;

@RestController
@RequestMapping("offering")
//@CrossOrigin(origins = "http://localhost:4200")

public class OfferingController {

	public Offering offering;
	@Autowired
	OfferingAppService offeringAppService;

	@RequestMapping(value = "", method = RequestMethod.POST)
	public Offering createOffering(@RequestBody Offering offering) {
		Offering status = offeringAppService.addOfferingDetails(offering);
		return status;
	}

	@RequestMapping(path="/{offeringId}",method = RequestMethod.DELETE)
	public Offering deleteOfferingDetails(@PathVariable("offeringId") int offeringId) {
		 return offeringAppService.deleteOffering(offeringId);
		
	}
	
	@RequestMapping(path="{offeringId}",method = RequestMethod.PUT)
	public Offering updateOfferingDetails(@PathVariable("offeringId") int offeringId,@RequestBody Offering offering) {
		offering.setOfferingid(offeringId);
		Offering status = offeringAppService.updateOfferingName(offering);
		return status;
	}
	@RequestMapping(path="/{offeringId}",method = RequestMethod.GET)
	public Offering getOfferingDetail(@PathVariable("offeringId") int offeringId) {
		Offering offering = offeringAppService.getOfferingById(offeringId);
		return offering;

	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Offering> getOfferingDetails(@RequestParam String offeringName) {
		List<Offering> offerings = offeringAppService.getOfferings(offeringName);
		return offerings;

	}
}
