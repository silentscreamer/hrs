package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.constants.ResultCode;
import com.example.dto.ResultObject;
import com.example.entity.User;
import com.example.repository.UserRepository;
import com.example.service.UserService;
import com.example.utils.CustomException;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUser(Long userId) {
		return userRepository.findById(userId).orElse(null);
	}

	@Override
	public ResultObject createUser(User user) throws CustomException{
		ResultObject object = new ResultObject(true, ResultCode.SUCCESS);
		
		object.getData().add(userRepository.save(user));
		return object;
	}

	@Override
	public ResultObject updateUser(User user)throws CustomException {
		ResultObject object = new ResultObject(true, ResultCode.SUCCESS);
		if(getUser(user.getId())==null) {
			throw new CustomException(ResultCode.USER_DOES_NOT_EXIST);
		}
		userRepository.save(user);
		return object;
	}

	@Override
	public ResultObject deleteUser(Long userId) {
		ResultObject object = new ResultObject(true, ResultCode.SUCCESS);
		userRepository.deleteById(userId);
		return object;
	}

	@Override
	public User getUserByEmail(String email) {
		return userRepository.getUserByEmail(email);
	}

}
