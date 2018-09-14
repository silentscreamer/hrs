package com.example.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import com.mongodb.client.gridfs.model.GridFSFile;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import com.example.constants.ResultCode;
import com.example.dto.ReturnValue;
import com.example.entity.User;
import com.example.repository.UserRepository;
import com.example.service.UserService;
import com.example.utils.CustomException;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  UserRepository userRepository;

  @Autowired
  GridFsTemplate gridFsTemplate;


  @Override
  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  @Override
  public User getUser(Long userId) {
    return userRepository.findById(userId).orElse(null);
  }

  @Override
  public ReturnValue createUser(User user) throws CustomException {
    ReturnValue object = new ReturnValue(true, ResultCode.SUCCESS);

    object.getData().add(userRepository.save(user));
    return object;
  }

  @Override
  public ReturnValue updateUser(User user) throws CustomException {
    ReturnValue object = new ReturnValue(true, ResultCode.SUCCESS);
    if (getUser(user.getId()) == null) {
      throw new CustomException(ResultCode.USER_DOES_NOT_EXIST);
    }
    userRepository.save(user);
    return object;
  }

  @Override
  public ReturnValue deleteUser(Long userId) {
    ReturnValue object = new ReturnValue(true, ResultCode.SUCCESS);
    userRepository.deleteById(userId);
    return object;
  }

  @Override
  public User getUserByEmail(String email) {
    return userRepository.getUserByEmail(email);
  }

  @Override
  public List<User> getAllUsersForAnOranization(Long organizationId) throws CustomException {
    return userRepository.getUsersForAnOrganization(organizationId);
  }

  @Override
  public ReturnValue uploadProfilePic(MultipartFile file, Long userId)
      throws IOException, CustomException {
    ReturnValue object = new ReturnValue(true, ResultCode.SUCCESS);
    String profilePicId =
        gridFsTemplate.store(file.getInputStream(), file.getOriginalFilename()).toHexString();
    User user = userRepository.findById(userId).orElse(null);
    if (user == null) {
      throw new CustomException(ResultCode.USER_DOES_NOT_EXIST);
    }

    user.setPic_Id(profilePicId);
    userRepository.save(user);
    return object;
  }

  @Override
  public File getUserProfilePic(Long id)
      throws CustomException, FileNotFoundException, IOException {
    User user = userRepository.findById(id).orElse(null);
    if (user == null) {
      throw new CustomException(ResultCode.USER_DOES_NOT_EXIST);
    }
    GridFSFile gridFsFile =
        gridFsTemplate.findOne(new Query(Criteria.where("_id").is(user.getPic_Id())));
    File file = new File(gridFsFile.getFilename());
    GridFsResource resource = gridFsTemplate.getResource(gridFsFile.getFilename());
    IOUtils.copy(resource.getInputStream(), new FileOutputStream(file));
    return file;
  }

}
