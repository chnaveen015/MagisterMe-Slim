package com.magister.slim.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.magister.slim.entity.StudyGuide;


public interface StudyGuideInterface extends MongoRepository<StudyGuide,Integer>{

	@Query("{'studyGuideName':?0}")
	List<StudyGuide> getStudyGuides(String studyGuideName);
}
