package com.example.service;

import java.io.IOException;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.web.multipart.MultipartFile;

import com.example.dto.ResultObject;
import com.example.entity.User;
import com.example.utils.CustomException;

public interface UserService {
	List<User> getAllUsers();
	User getUser(Long userId);
	ResultObject createUser(User user) throws CustomException;
	ResultObject updateUser(User user) throws CustomException;
	ResultObject deleteUser(Long userId);
	ObjectId uploadProfilePic(MultipartFile file) throws IOException;
	User getUserByEmail(String email);
}
