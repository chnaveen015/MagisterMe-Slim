package com.magister.slim.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.magister.slim.entity.Resource;
import com.magister.slim.references.StudyGuideReference;
import com.magister.slim.references.TeacherReference;
import com.magister.slim.repository.ResourceInterface;

@Service
public class ResourceAppService {

	@Autowired
	ResourceInterface resourceInterface;
	
	public List<Resource> getResources()
	{
		List<Resource> resources=resourceInterface.findAll();
		return resources;
	}
	public Resource deleteResource(Resource resource)
	{
		resourceInterface.deleteById(resource.getResourceId());
		return resource;
	}
	public Resource addResource(Resource resource,TeacherReference teacher)
	{
		resource.setCreatedBy(teacherDetails(teacher.getTeacherid(),teacher.getName()));
		//resource.setStudyGuideReference(studyGuideDetails(studyGuide.getStudyGuideIdId(), studyGuide.getStudyGuideName()));
		resourceInterface.save(resource);
		return resource;
	}
	public TeacherReference teacherDetails(int id,String teacherName)
	{
		TeacherReference teacherReference = new TeacherReference();
		teacherReference.setTeacherid(id);
		teacherReference.setName(teacherName);
		return teacherReference;
	}
	public StudyGuideReference studyGuideDetails(int id ,String studyGuideName)
	{
		StudyGuideReference studyGuideReference=new StudyGuideReference();
		studyGuideReference.setStudyGuideId(id);
		studyGuideReference.setStudyGuideName(studyGuideName);
		return studyGuideReference;
	}
	public Resource getResource(int resourceid) {
		Resource resource=resourceInterface.findById(resourceid).get();
		return resource;
	}
}
