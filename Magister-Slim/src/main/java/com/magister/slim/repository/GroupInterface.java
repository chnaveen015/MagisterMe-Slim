package com.magister.slim.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.magister.slim.entity.Group;

public interface GroupInterface extends MongoRepository<Group,Integer>{

	@Query("{'groupName':?0}")
	Group getGroupByName(String groupName);

}
