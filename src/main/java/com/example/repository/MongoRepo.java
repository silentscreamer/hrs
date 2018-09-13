package com.example.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.example.entity.User;
import com.example.entity.UserPic;

@Repository
public interface MongoRepo extends MongoRepository<UserPic, Long>{

	void save(MultipartFile file, String string);

}
