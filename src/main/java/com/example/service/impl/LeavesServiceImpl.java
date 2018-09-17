package com.example.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.constants.LeaveType;
import com.example.constants.ResultCode;
import com.example.constants.Status;
import com.example.dto.ReturnValue;
import com.example.entity.UserLeave;
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
  public ReturnValue requestLeave(UserLeave leave) throws CustomException {
    ReturnValue value = new ReturnValue(true, ResultCode.SUCCESS);
    leave.setStatus(Status.REQUESTED);
    value.getData().add(leavesRepo.save(leave));
    return value;
  }

  @Override
  public ReturnValue approveLeave(UserLeave leave) throws CustomException {
    ReturnValue value = new ReturnValue(true, ResultCode.SUCCESS);
    leavesRepo.save(leave);
    if (leave.getStatus().equals(Status.APPROVE.toString())) {
      User user = userRepo.findById(leave.getUserId()).orElse(null);
      LeaveType leaveType = leave.getTypeOfLeave();
      switch (String.valueOf(leaveType)) {
        case "EARNED":
          user.getLeaveDetail().setNumOfEarnedLeaves(user.getLeaveDetail().getNumOfEarnedLeaves() - leave.getNumberOfLeaves());
          break;
        case "CASUAL":
          user.getLeaveDetail().setNumOfCasualLeaves(user.getLeaveDetail().getNumOfCasualLeaves() - leave.getNumberOfLeaves());
          break;
        case "SICK":
          user.getLeaveDetail().setNumOfSickLeaves(user.getLeaveDetail().getNumOfSickLeaves() - leave.getNumberOfLeaves());
          break;
      }
      userRepo.save(user);
    }
    return value;
  }

  @Override
  public List<UserLeave> getLeaves(Long managerId) throws CustomException {
    return leavesRepo.getLeavesForaManager(managerId);
  }


}
