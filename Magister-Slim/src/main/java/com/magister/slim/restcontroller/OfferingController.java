package com.magister.slim.restcontroller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.magister.slim.entity.Offering;
import com.magister.slim.entity.OfferingLevel;
import com.magister.slim.service.OfferingAppService;

@RestController
@RequestMapping("offering")
//@CrossOrigin(origins = "http://localhost:4200")

public class OfferingController {

	public Offering offering;
	@Autowired
	OfferingAppService offeringAppService;

	@RequestMapping(value = "", method = RequestMethod.POST)
	public Offering add(@RequestBody Offering offering) {
		Offering status = offeringAppService.addOffering(offering);
		System.out.println(status);
		return status;
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public Offering delete(@RequestBody Offering offering, HttpServletRequest request, HttpServletResponse response) {
		Offering status = offeringAppService.deleteOffering(offering);
		return status;
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public Offering update(@RequestBody Offering offering) {
		OfferingLevel offeringLevel=new OfferingLevel();
		Offering status = offeringAppService.updateOffering(offeringLevel);
		return status;
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Offering> get() {
		List<Offering> offerings = offeringAppService.getOfferings();
		return offerings;

	}
}
