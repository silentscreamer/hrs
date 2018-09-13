package com.example.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.configuration.SpringMongoConfig;
import com.example.constants.ResultCode;
import com.example.dto.ResultObject;
import com.example.entity.User;
import com.example.repository.UserRepository;
import com.example.service.UserService;
import com.example.utils.CustomException;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSBuckets;
import com.mongodb.client.gridfs.model.GridFSFile;
import com.mongodb.gridfs.GridFSDBFile;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	GridFsOperations gridFs;
	
	@Autowired
	SpringMongoConfig grid;
	
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

	@Override
	public ResultObject uploadProfilePic(MultipartFile file,Long userId) throws IOException {
		ResultObject object = new ResultObject(true, ResultCode.SUCCESS);
		String id = gridFs.store(file.getInputStream(),"png","image/png").toString();
		User user = new User();
		 user = userRepository.findById(userId).orElse(null);
		user.setPic_Id(id);
		userRepository.save(user);
		return object;
	}

	@Override
	public byte[] getProfilePic(Long id) {
		String imageFileId = "5b0bff8b7cc45b32f43b47f4";
		GridFSBucket gridFSBucket = GridFSBuckets.create(grid.mongoDbFactory().getDb());
		User user = userRepository.findById(id).orElse(null);
		GridFSFile gridFsdbFile = gridFs.findOne(new Query(Criteria.where("_id").is(user.getPic_Id())));
		try {
            File file = new File("/Users/saquibali/Desktop/Profile_pic.png");
            FileOutputStream streamToDownloadTo = new FileOutputStream(file);
            gridFSBucket.downloadToStream(gridFsdbFile.getId(), streamToDownloadTo);
            streamToDownloadTo.close();
        } catch (IOException e) {
            // handle exception
            System.out.println("error: " + e.getMessage());
        } catch (Exception e1) {
            e1.printStackTrace();
        }
		return null;
		
		
	}

}
