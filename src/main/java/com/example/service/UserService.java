package com.example.service;

import java.io.IOException;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
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
	ResultObject uploadProfilePic(MultipartFile file,Long userId) throws IOException;
	byte[] getProfilePic(Long id);
	User getUserByEmail(String email);
}
