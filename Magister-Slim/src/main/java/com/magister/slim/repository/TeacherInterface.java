package com.magister.slim.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.magister.slim.entity.Teacher;

public interface TeacherInterface extends MongoRepository<Teacher,Integer>{

}
