package com.example.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.example.service.UserService;
import com.example.utils.CustomException;

/**
 * @author salman.kazmi
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {

	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserService userService;

	/**
	 * @return
	 */
	@GetMapping("/all")
	public ResultObject getAllUsers() {
		ResultObject object = new ResultObject(true, ResultCode.SUCCESS);
		object.getData().addAll(userService.getAllUsers());
		return object;
	}

	/**
	 * @param user
	 * @return
	 */
	@PostMapping("/add")
	public ResultObject createUser(@Valid @RequestBody User user) {
		try {
			if (userService.getUserByEmail(user.getEmail()) != null) {
				throw new CustomException(ResultCode.USER_ALREADY_EXISTS);
			}
			log.info("Creating a New User");
			return userService.createUser(user);
		} catch (CustomException ce) {
			log.error("CustomException :", ce);
			return new ResultObject(false, ce.getResultCode());
		} catch (Exception e) {
			log.error("Exception :", e);
			return new ResultObject(false, ResultCode.SYSTEM_ERROR);
		}
	}

	/**
	 * @param userId
	 * @return
	 */
	@GetMapping("/{id}")
	public ResultObject getUser(@PathVariable(value = "id") Long userId) {
		ResultObject object = new ResultObject(true, ResultCode.SUCCESS);
		object.getData().add(userService.getUser(userId));
		return object;
	}

	/**
	 * @param user
	 * @return
	 */
	@PutMapping("/{id}")
	public ResultObject updateUser(@RequestBody User user) {
		ResultObject object;
		try {
			object = userService.updateUser(user);
		} catch (CustomException ce) {
			log.error("CustomException :", ce);
			return new ResultObject(false, ce.getResultCode());
		} catch (Exception e) {
			log.error("Exception :", e);
			return new ResultObject(false, ResultCode.SYSTEM_ERROR);
		}
		return object;
	}

	/**
	 * @param userId
	 * @return
	 */
	@DeleteMapping("/{id}")
	public ResultObject deleteUser(@PathVariable(value = "id") Long userId) {
		return userService.deleteUser(userId);
	}
	
	@GetMapping("/organization/{id}")
	public ResultObject getAllUsersForAnOrganization(@PathVariable(value = "id") Long organizationId) {
		ResultObject object = new ResultObject(true, ResultCode.SUCCESS);
		try {
			object.getData().addAll(userService.getAllUsersForAnOranization(organizationId));
		} catch(CustomException ce) {
			log.error("CustomException :", ce);
			return new ResultObject(false, ce.getResultCode());
		} catch(Exception e) {
			log.error("Exception :", e);
			return new ResultObject(false, ResultCode.SYSTEM_ERROR);
		}
		return object;
	}
}
