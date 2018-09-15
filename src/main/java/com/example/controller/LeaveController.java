package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.constants.Status;
import com.example.dto.ReturnValue;
import com.example.entity.Leaves;
import com.example.service.LeavesService;

@RestController
@RequestMapping("/leaves")
public class LeaveController {
	
	@Autowired
	LeavesService leaveService;
	
	@PostMapping("/requestLeave")
	public ReturnValue requestLeave(Leaves leave){
		leave.setStatus(Status.REQUESTED.toString());
		ReturnValue value = leaveService.requestLeave(leave);
		return value;
		
	}
	

}
