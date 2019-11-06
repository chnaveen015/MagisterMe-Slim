package com.magister.slim.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.magister.slim.entity.StudyGuide;


public interface StudyGuideInterface extends MongoRepository<StudyGuide,Integer>{

}
