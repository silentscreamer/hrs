package com.example.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.User;
import com.example.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	UserRepository userRepository;

	// Get All Users
	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	// Create a new User
	@PostMapping("/user")
	public User createUser(@Valid @RequestBody User user) {
		return userRepository.save(user);
	}

	// Get a Single User
	@GetMapping("/user/{id}")
	public User getUser(@PathVariable(value="id") Long userId) {
		return userRepository.findById(userId).orElse(null);
	}

	// Update a User
	@PutMapping("/user/{id}")
	public User updateUser(@PathVariable(value="id") Long userId, 
			@RequestBody User user) {
		return null;
	}

	// Delete a User
	@DeleteMapping("/user/{id}")
	public ResponseEntity<?> deleteNote(@PathVariable(value="id") Long userId) {
		userRepository.deleteById(userId);
		return ResponseEntity.ok().build();
	}
}
