package com.magister.slim.restcontroller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.magister.slim.entity.Group;
import com.magister.slim.entity.Offering;
import com.magister.slim.entity.OfferingLevel;
import com.magister.slim.references.OfferingLevelReference;
import com.magister.slim.references.OfferingReference;
import com.magister.slim.references.TeacherReference;
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
	public Group createGroup(@PathVariable("offeringId")int offeringId,@PathVariable("offeringLevelId") int offeringLevelId,@RequestBody Group groupDetails) {
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
	public Group updateGroupDetails(@PathVariable("offeringId") int offeringId,@PathVariable("offeringLevelId") int offeringLevelId,@PathVariable("groupId")int groupId,@RequestBody Group groupDetails) {
		groupDetails.setGroupId(groupId);
		groupDetails.setOfferingLevelReference(new OfferingLevelReference());
		groupDetails.getOfferingLevelReference().setOfferingLevelId(offeringLevelId);
		Group status=groupAppService.updateGroupDetails(offeringId,groupDetails);
		return status;
	}

	@RequestMapping(value = "{groupId}", method = RequestMethod.DELETE)
	public Group deleteGroupDeatils(@PathVariable("offeringId") int offeringId,@PathVariable("offeringLevelId") int offeringLevelId,@PathVariable("groupId") int groupId) {
		Group status=groupAppService.deleteGroup(offeringId,offeringLevelId,groupId);
		return status;
	}

	@RequestMapping(value = "{groupId}", method = RequestMethod.GET)
	public Group getGroupDetails(@PathVariable("offeringId") int offeringId,@PathVariable("offeringLevelId") int offeringLevelId,@PathVariable("groupId") int groupId) {
		Group groupDetails=groupAppService.getGroupDetailsById(offeringLevelId,groupId);
			
		return groupDetails;

	}
	@GetMapping()
	public Group getGroupDetailsByName(@RequestParam("offeringId") int offeringId,
			@RequestParam("offeringLevelId") int offeringLevelId,@RequestParam("groupName") String groupName) {
		return groupAppService.getGroupByName(offeringLevelId,groupName);

	}
}
