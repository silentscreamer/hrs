package com.example.controller;

import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.example.entity.UserLeave;
import com.example.service.LeavesService;
import com.example.utils.CustomException;

@RestController
@RequestMapping("/leave")
public class LeaveController {

  private static final Logger log = LoggerFactory.getLogger(LeaveController.class);

  @Autowired
  LeavesService leaveService;

  @PostMapping("/request")
  public ReturnValue requestLeave(@Valid @RequestBody UserLeave leave) {
    try {
      return leaveService.requestLeave(leave);
    } catch (CustomException ce) {
      log.error("Exception :", ce);
      return new ReturnValue(false, ce.getResultCode());
    } catch (Exception e) {
      log.error("Exception :", e);
      return new ReturnValue(false, ResultCode.SYSTEM_ERROR);
    }
  }

  @PutMapping("/approve")
  public ReturnValue approveLeave(@RequestBody UserLeave leave) {
    try {
      return leaveService.approveLeave(leave);
    } catch (CustomException ce) {
      log.error("Exception :", ce);
      return new ReturnValue(false, ce.getResultCode());
    } catch (Exception e) {
      log.error("Exception :", e);
      return new ReturnValue(false, ResultCode.SYSTEM_ERROR);
    }
  }

  @GetMapping("/allLeaves/{managerId}")
  public ReturnValue getLeaves(@PathVariable(value = "managerId") Long managerId) {
    ReturnValue value = new ReturnValue(true, ResultCode.SUCCESS);
    try {
      value.getData().addAll(leaveService.getLeaves(managerId));
    } catch (CustomException ce) {
      log.error("Exception :", ce);
      return new ReturnValue(false, ce.getResultCode());
    } catch (Exception e) {
      log.error("Exception :", e);
      return new ReturnValue(false, ResultCode.SYSTEM_ERROR);
    }
    return value;
  }
}
