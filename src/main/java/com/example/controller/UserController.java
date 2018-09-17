package com.example.controller;

import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.example.constants.ResultCode;
import com.example.dto.ReturnValue;
import com.example.entity.User;
import com.example.service.UserService;
import com.example.utils.CustomException;

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
  public ReturnValue getAllUsers() {
    ReturnValue object = new ReturnValue(true, ResultCode.SUCCESS);
    object.getData().addAll(userService.getAllUsers());
    return object;
  }

  /**
   * @param user
   * @return
   */
  @PostMapping("/add")
  public ReturnValue createUser(@Valid @RequestBody User user) {
    try {
      if (userService.getUserByEmail(user.getEmail()) != null) {
        throw new CustomException(ResultCode.USER_ALREADY_EXISTS);
      }
      log.info("Creating a New User");
      return userService.createUser(user);
    } catch (CustomException ce) {
      log.error("CustomException :", ce);
      return new ReturnValue(false, ce.getResultCode());
    } catch (Exception e) {
      log.error("Exception :", e);
      return new ReturnValue(false, ResultCode.SYSTEM_ERROR);
    }
  }

  // Get a Single User
  /**
   * @param userId
   * @return
   */
  @GetMapping("/{id}")
  public ReturnValue getUser(@PathVariable(value = "id") Long userId) {
    ReturnValue object = new ReturnValue(true, ResultCode.SUCCESS);
    object.getData().add(userService.getUser(userId));
    return object;
  }

  /**
   * @param user
   * @return
   */
  @PutMapping("/{id}")
  public ReturnValue updateUser(@RequestBody User user) {
    ReturnValue object;
    try {
      object = userService.updateUser(user);
    } catch (CustomException ce) {
      log.error("CustomException :", ce);
      return new ReturnValue(false, ce.getResultCode());
    } catch (Exception e) {
      log.error("Exception :", e);
      return new ReturnValue(false, ResultCode.SYSTEM_ERROR);
    }
    return object;
  }

  /**
   * @param userId
   * @return
   */
  @DeleteMapping("/{id}")
  public ReturnValue deleteUser(@PathVariable(value = "id") Long userId) {
    return userService.deleteUser(userId);
  }

  @GetMapping("/organization/{id}")
  public ReturnValue getAllUsersForAnOrganization(@PathVariable(value = "id") Long organizationId) {
    ReturnValue object = new ReturnValue(true, ResultCode.SUCCESS);
    try {
      object.getData().addAll(userService.getAllUsersForAnOranization(organizationId));
    } catch (CustomException ce) {
      log.error("CustomException :", ce);
      return new ReturnValue(false, ce.getResultCode());
    } catch (Exception e) {
      log.error("Exception :", e);
      return new ReturnValue(false, ResultCode.SYSTEM_ERROR);
    }
    return object;
  }

  @PostMapping("/uploadProfilePic/{id}")
  public ReturnValue uploadProfilePic(@RequestParam MultipartFile file,
      @PathVariable(value = "id") Long userId) {
    try {
      return userService.uploadProfilePic(file, userId);
    } catch (CustomException ce) {
      log.error("CustomException :", ce);
      return new ReturnValue(false, ce.getResultCode());
    } catch (Exception e) {
      log.error("Exception :", e);
      return new ReturnValue(false, ResultCode.SYSTEM_ERROR);
    }
  }

  /**
   * @param userId
   * @param response
   */
  @GetMapping("/profilePic/{id}")
  public ResponseEntity<InputStreamResource> getUserProfilePic(
      @PathVariable(value = "id") Long userId) {
    try {
      return userService.getUserProfilePic(userId);
    } catch (CustomException ce) {
      log.error("CustomException :", ce);
      // return new ReturnValue(false, ce.getResultCode());
    } catch (Exception e) {
      log.error("Exception :", e);
      // return new ReturnValue(false, ResultCode.SYSTEM_ERROR);
    }
    return null;
  }

}
