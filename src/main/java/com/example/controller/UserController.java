package com.example.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.constants.ResultCode;
import com.example.dto.ResultObject;
import com.example.entity.User;
import com.example.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	UserRepository userRepository;

	// Get All Users
	@GetMapping("/users")
	public ResultObject getAllUsers() {
		ResultObject object = new ResultObject(true, ResultCode.SUCCESS);
		object.getData().addAll(userRepository.findAll());
		return object;
	}

	// Create a new User
	@PostMapping("/user")
	public ResultObject createUser(@Valid @RequestBody User user) {
		ResultObject object = new ResultObject(true, ResultCode.SUCCESS);
		object.getData().add(userRepository.save(user));
		return object;
	}

	// Get a Single User
	@GetMapping("/user/{id}")
	public ResultObject getUser(@PathVariable(value = "id") Long userId) {
		ResultObject object = new ResultObject(true, ResultCode.SUCCESS);
		object.getData().add(userRepository.findById(userId).orElse(null));
		return object;
	}

	// Update a User
	@PutMapping("/user/{id}")
	public ResultObject updateUser(@RequestBody User user) {
		ResultObject object = new ResultObject(true, ResultCode.SUCCESS);
		userRepository.save(user);
		return object;
	}

	// Delete a User
	@DeleteMapping("/user/{id}")
	public ResultObject deleteUser(@PathVariable(value = "id") Long userId) {
		ResultObject object = new ResultObject(true, ResultCode.SUCCESS);
		userRepository.deleteById(userId);
		return object;
	}
}
