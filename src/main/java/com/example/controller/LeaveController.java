package com.example.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.constants.ResultCode;
import com.example.constants.Status;
import com.example.dto.ReturnValue;
import com.example.entity.Leaves;
import com.example.service.LeavesService;
import com.example.utils.CustomException;

@RestController
@RequestMapping("/leaves")
public class LeaveController {

	@Autowired
	LeavesService leaveService;

	@PostMapping("/requestLeave")
	public ReturnValue requestLeave(@Valid @RequestBody Leaves leave) {
		ReturnValue value = new ReturnValue();
		leave.setStatus(Status.REQUESTED.toString());
		try {
			leaveService.requestLeave(leave);
			value = new ReturnValue(true, ResultCode.LEAVE_REQUESTED_SUCCESSFULLY);
		} catch (CustomException exception) {
			value = new ReturnValue(false, ResultCode.SYSTEM_ERROR);
		}

		return value;

	}

	@PutMapping("/leaveApproval")
	public ReturnValue leaveApproval(@RequestBody Leaves leave) {
		ReturnValue value = new ReturnValue();
		try {
			leaveService.approveLeave(leave);
			if (leave.getStatus().equals(Status.APPROVE.toString())) {
				value.setSuccess(true);
				value.setMessage(ResultCode.LEAVE_APPROAVED.toString());
			} else {
				value.setSuccess(true);
				value.setMessage(ResultCode.LEAVE_DENIED.toString());
			}
		} catch (CustomException exception) {
			value.setSuccess(false);
			value.setMessage(ResultCode.ERROR.toString());
		}
		return value;
	}

	@GetMapping("/getLeaves/{managerId}")
	public ReturnValue getLeaves(@PathVariable(value = "managerId") int managerId) {
		ReturnValue value = new ReturnValue();
		try{
			value.setSuccess(true);
			value.setResult(ResultCode.SUCCESS);
			value.getData().addAll(leaveService.getLeaves(managerId));
		}catch(CustomException exception){
			exception.setErrorMessage("Unable to get leaves");
		}
		return value;
	}
}
