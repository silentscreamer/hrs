package com.example.service;

import java.io.IOException;
import java.util.List;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import com.example.dto.ReturnValue;
import com.example.entity.User;
import com.example.utils.CustomException;

public interface UserService {
  List<User> getAllUsers();

  User getUser(Long userId);

  ReturnValue createUser(User user) throws CustomException;

  ReturnValue updateUser(User user) throws CustomException;

  ReturnValue deleteUser(Long userId);

  ReturnValue uploadProfilePic(MultipartFile file, Long userId) throws IOException, CustomException;

  ResponseEntity<InputStreamResource> getUserProfilePic(Long id) throws CustomException, IOException;

  User getUserByEmail(String email);

  List<User> getAllUsersForAnOranization(Long organizationId) throws CustomException;
}
