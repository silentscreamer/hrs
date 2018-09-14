package com.example.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.dto.Message;

@Repository
public interface MessageRepository extends MongoRepository<Message, String> {
	Message findBy_id(ObjectId _id);
	List<Message> findAllMessagesBySender(ObjectId _id);
}
