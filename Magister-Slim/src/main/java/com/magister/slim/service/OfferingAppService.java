package com.magister.slim.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.magister.slim.entity.Offering;
import com.magister.slim.entity.OfferingLevel;
import com.magister.slim.references.OfferingLevelReference;
import com.magister.slim.repository.OfferingInterface;

@Service
public class OfferingAppService {

	@Autowired
	OfferingInterface offeringInterface;

	public List<Offering> getOfferings() {
		List<Offering> offeringLevel = offeringInterface.findAll();
		return offeringLevel;
	}

	public Offering deleteOffering(Offering offering) {
		offeringInterface.deleteById(offering.getOfferingid());
		return offering;
	}

	public Offering addOffering(Offering offering) {
		return offeringInterface.save(offering);
	}

	public Offering updateOffering(OfferingLevel offeringLevel) {
		Offering offering = offeringInterface.findById(offeringLevel.getOfferingReference().getOfferingId()).get();
		offering.setOfferingLevels(offeringLevelDetails(offeringLevel.getOfferingLevelId(),
				offeringLevel.getOfferingLevelName(), offering));
		return offeringInterface.save(offering);
	}

	public List<OfferingLevelReference> offeringLevelDetails(int id, String offeringLevelName, Offering offering) {
		OfferingLevelReference offeringLevelReference = new OfferingLevelReference();
		List<OfferingLevelReference> offeringLevels = new ArrayList<OfferingLevelReference>();
		offeringLevels = offering.getOfferingLevels();
		if (offeringLevels == null)
			offeringLevels = new ArrayList<OfferingLevelReference>();
		offeringLevelReference.setOfferingLevelid(id);
		offeringLevelReference.setOfferingLevelName(offeringLevelName);
		offeringLevels.add(offeringLevelReference);
		return offeringLevels;
	}

	public Offering getOffering(int offeringid) {
		Offering group = offeringInterface.findById(offeringid).get();
		return group;
	}

}
