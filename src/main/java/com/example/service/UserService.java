package com.example.service;

import java.util.List;

import com.example.dto.ResultObject;
import com.example.entity.User;
import com.example.utils.CustomException;

public interface UserService {
	List<User> getAllUsers();

	User getUser(Long userId);

	ResultObject createUser(User user) throws CustomException;

	ResultObject updateUser(User user) throws CustomException;

	ResultObject deleteUser(Long userId);

	User getUserByEmail(String email);
	
	List<User> getAllUsersForAnOranization(Long organizationId) throws CustomException;
}
