package com.example.service.impl;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.constants.ResultCode;
import com.example.dto.Message;
import com.example.dto.ResultObject;
import com.example.repository.MessageRepository;
import com.example.service.MessageService;
import com.example.utils.CustomException;

@Service
public class MessageServiceImpl implements MessageService {

	/*@Autowired
	MessageRepository messageRepository;*/

	/*@Override
	public Message getMessageById(String id) throws CustomException {
		return messageRepository.findBy_id(new ObjectId(id));
	}

	@Override
	public ResultObject sendMessage(Message message) throws CustomException {
		ResultObject object = new ResultObject(true, ResultCode.SUCCESS);
		object.getData().add(messageRepository.save(message));
		return object;
	}

	@Override
	public List<Message> getAllMessagesBySender(String senderId) throws CustomException {
		return messageRepository.findAllMessagesBySender(new ObjectId(senderId));
	}*/
}
