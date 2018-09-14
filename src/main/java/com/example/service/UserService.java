package com.example.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

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

	ResultObject uploadProfilePic(MultipartFile file, Long userId) throws IOException, CustomException;

	File getUserProfilePic(Long id)throws CustomException, FileNotFoundException, IOException;

	User getUserByEmail(String email);
	
	List<User> getAllUsersForAnOranization(Long organizationId) throws CustomException;
}
