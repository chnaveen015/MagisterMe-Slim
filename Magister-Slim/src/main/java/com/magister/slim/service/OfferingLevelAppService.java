package com.magister.slim.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.magister.slim.entity.OfferingLevel;
import com.magister.slim.repository.OfferingLevelInterface;

@Service
public class OfferingLevelAppService {
	
	@Autowired
	OfferingLevelInterface offeringLevelInterface;
	@Autowired
	OfferingAppService offeringAppService;
	
	public OfferingLevel deleteOfferingLevel(OfferingLevel offeringLevel)
	{
		offeringLevelInterface.deleteById(offeringLevel.getOfferingLevelId());
		return offeringLevel;
	}
	
	public OfferingLevel addOfferingLevel(OfferingLevel offeringLevel)
	{
		offeringAppService.updateOffering( offeringLevel);
		offeringLevelInterface.save(offeringLevel);
		return offeringLevel;
	}

	public List<OfferingLevel> getOfferingLevels() {
		List<OfferingLevel> offeringLevels=offeringLevelInterface.findAll();
		return offeringLevels;
	}
	public OfferingLevel getOfferingLevel(int offeringLevelid) {
		OfferingLevel group = offeringLevelInterface.findById(offeringLevelid).get();
		return group;
	}
	

}
