package com.magister.slim.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.magister.slim.entity.Course;

public interface CourseInterface extends MongoRepository<Course,Integer>{

}
