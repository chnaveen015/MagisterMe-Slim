package com.magister.slim.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.magister.slim.entity.Offering;
import com.magister.slim.entity.OfferingLevel;
import com.magister.slim.references.OfferingLevelReference;
import com.magister.slim.references.OfferingReference;
import com.magister.slim.repository.OfferingInterface;

@Service
public class OfferingAppService {

	@Autowired
	OfferingInterface offeringInterface;

	public Offering addOfferingDetails(Offering offering) {
		return offeringInterface.save(offering);
	}

	public Offering deleteOffering(int offeringId) {
		Offering offering = offeringInterface.findById(offeringId).get();
		offering.setActive(false);
		return offeringInterface.save(offering);

	}

	public Offering updateOfferingName(Offering offering) {
		Offering offeringDetails = offeringInterface.findById(offering.getOfferingid()).get();
		offeringDetails.setOfferingName(offering.getOfferingName());
		return offeringInterface.save(offeringDetails);

	}

	public List<Offering> getOfferings(String offeringName) {
		return offeringInterface.getOfferingsByName(offeringName);
	}

	public Offering getOfferingById(int offeringId) {
		if(offeringInterface.findById(offeringId).isPresent())
			return offeringInterface.findById(offeringId).get();
		else return null;
	}

	public boolean updateOfferingReferences(OfferingLevel offeringLevel) {
		List<OfferingLevelReference> offeringLevelReferences = new ArrayList<OfferingLevelReference>();
		if(offeringInterface.findById(offeringLevel.getOfferingReference().getOfferingId()).isPresent())
		{
		Offering offering = offeringInterface.findById(offeringLevel.getOfferingReference().getOfferingId()).get();
		offeringLevelReferences = offering.getOfferingLevelReferences();
		if (offeringLevelReferences == null)
			offeringLevelReferences = new ArrayList<OfferingLevelReference>();
		offeringLevelReferences.add(new OfferingLevelReference(offeringLevel.getOfferingLevelId(),
				offeringLevel.getOfferingLevelName(), offeringLevel.isActive()));
		offering.setOfferingLevelReferences(offeringLevelReferences);
		offeringInterface.save(offering);
		return true;
		}
		else
			return false;
	}

	public boolean deleteOfferingLevelReference(int offeringId, int offeringLevelId) {

		Offering offering = offeringInterface.findById(offeringId).get();
		List<OfferingLevelReference> offeringLevelReferences = offering.getOfferingLevelReferences().stream().map(offeringReference -> {
			if (offeringReference.getOfferingLevelId() == offeringLevelId) {
				offeringReference.setActive(false);	
			}
			return offeringReference;
		}).collect(Collectors.toList());
		offering.setOfferingLevelReferences(offeringLevelReferences);
		offeringInterface.save(offering);
		return true;

	}

	public boolean updateOfferingLevelReferenceDetails(OfferingLevel offeringLevel) {
		Offering offering = offeringInterface.findById(offeringLevel.getOfferingReference().getOfferingId()).get();
		List<OfferingLevelReference> offeringLevelReferences = offering.getOfferingLevelReferences().stream().map(offeringReference -> {
			if (offeringReference.getOfferingLevelId() ==offeringLevel.getOfferingLevelId()) {
				offeringReference.setOfferingLevelName(offeringLevel.getOfferingLevelName());	
			}
			return offeringReference;
		}).collect(Collectors.toList());
		offering.setOfferingLevelReferences(offeringLevelReferences);
		offeringInterface.save(offering);
		return true;
	}

//	public boolean checkOfferingLevelReferenceDetails(int offeringId, int offeringLevelId) {
//		if(offeringInterface.findById(offeringId).isPresent())
//		{
//		Offering offering = offeringInterface.findById(offeringId).get();
//		
//		boolean offeringLevelReference = offering.getOfferingLevelReferences().stream().filter((offeringReference) -> offeringReference.getOfferingLevelId() == offeringLevelId).findAny().isPresent();
//		if(offeringLevelReference)
//			return true;
//		else 
//			return false;
//		}
//		return false;
//
//
//	}
}
