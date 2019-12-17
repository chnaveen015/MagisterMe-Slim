package com.magister.slim.restcontroller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.magister.slim.entity.Group;
import com.magister.slim.references.OfferingLevelReference;
import com.magister.slim.service.GroupAppService;
import com.magister.slim.service.OfferingLevelAppService;

@RestController
@RequestMapping("offering/{offeringId}/offering-level/{offeringLevelId}/group")
//@CrossOrigin(origins = "http://localhost:4200")
public class GroupController {

	@Autowired
	GroupAppService groupAppService;
	@Autowired
	OfferingLevelAppService offeringLevelAppService;

	@PostMapping()
	public Group createGroup(@PathVariable("offeringId")String offeringId,@PathVariable("offeringLevelId") String offeringLevelId,@RequestBody Group groupDetails) {
		groupDetails.setActive(true);
		
		OfferingLevelReference offeringLevelReference=offeringLevelAppService.getOfferingLevelReference(offeringId,offeringLevelId);
		if(offeringLevelReference!=null)
		{
			groupDetails.setOfferingLevelReference(offeringLevelReference);
		Group status = groupAppService.addGroupDetails(groupDetails);
		return status;
		}
		else return null;
	}

	@RequestMapping(value = "/{groupId}", method = RequestMethod.PUT)
	public Group updateGroupDetails(@PathVariable("offeringId") String offeringId,@PathVariable("offeringLevelId") String offeringLevelId,@PathVariable("groupId")String groupId,@RequestBody Group groupDetails) {
		groupDetails.setGroupId(groupId);
		groupDetails.setOfferingLevelReference(new OfferingLevelReference());
		groupDetails.getOfferingLevelReference().setOfferingLevelId(offeringLevelId);
		Group status=groupAppService.updateGroupDetails(offeringId,groupDetails);
		return status;
	}

	@RequestMapping(value = "{groupId}", method = RequestMethod.DELETE)
	public Group deleteGroupDeatils(@PathVariable("offeringId") String offeringId,@PathVariable("offeringLevelId") String offeringLevelId,@PathVariable("groupId") String groupId) {
		Group status=groupAppService.deleteGroup(offeringId,offeringLevelId,groupId);
		return status;
	}

	@RequestMapping(value = "{groupId}", method = RequestMethod.GET)
	public Group getGroupDetails(@PathVariable("offeringId") String offeringId,@PathVariable("offeringLevelId") String offeringLevelId,@PathVariable("groupId") String groupId) {
		Group groupDetails=groupAppService.getGroupDetailsById(offeringLevelId,groupId);
			
		return groupDetails;

	}
	@GetMapping()
	public List<Group> getGroupDetailsByName(@RequestParam("offeringId") String offeringId,
			@RequestParam("offeringLevelId") int offeringLevelId,@RequestParam("groupName") String groupName) {
		return groupAppService.getGroupByName(offeringLevelId,groupName);

	}
}
