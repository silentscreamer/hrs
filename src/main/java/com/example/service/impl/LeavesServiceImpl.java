package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.constants.ResultCode;
import com.example.constants.Status;
import com.example.dto.ReturnValue;
import com.example.entity.Leaves;
import com.example.entity.User;
import com.example.repository.LeavesRepository;
import com.example.repository.UserRepository;
import com.example.service.LeavesService;
import com.example.utils.CustomException;

@Service
public class LeavesServiceImpl implements LeavesService {

	@Autowired
	LeavesRepository leavesRepo;
	@Autowired
	UserRepository userRepo;

	@Override
	public ReturnValue requestLeave(Leaves leave) throws CustomException {
		ReturnValue value = new ReturnValue(true, ResultCode.SUCCESS);
		value.getData().add(leavesRepo.save(leave));
		return value;
	}

	@Override
	public ReturnValue approveLeave(Leaves leave) throws CustomException {
		ReturnValue value = new ReturnValue();
		leavesRepo.save(leave);
		if (leave.getStatus().equals(Status.APPROVE.toString())) {
			User user = userRepo.findById(Long.parseLong(String.valueOf(leave.getUserId()))).orElse(null);
			String leaveType = leave.getTypeOfLeave();
			switch (leaveType) {
			case "EARNED":
				user.setNumOfEarnedLeaves(user.getNumOfEarnedLeaves() - leave.getNumberOfLeaves());
				break;
			case "CASUAL":
				user.setNumOfCasualLeaves(user.getNumOfCasualLeaves() - leave.getNumberOfLeaves());
				break;
			case "SICK":
				user.setNumOfSickLeaves(user.getNumOfSickLeaves() - leave.getNumberOfLeaves());
				break;
			default:
				break;
			}
			userRepo.save(user);
		}
		return value;
	}

	@Override
	public List<Leaves> getLeaves(int managerId) throws CustomException {
		
		return leavesRepo.getLeavesForaManager(managerId);
		
	}

	
}
