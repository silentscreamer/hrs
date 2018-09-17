package com.example.service;

import java.util.List;
import com.example.dto.ReturnValue;
import com.example.entity.UserLeave;
import com.example.utils.CustomException;

public interface LeavesService {

  /**
   * @param leave
   * @return
   * @throws CustomException
   */
  ReturnValue requestLeave(UserLeave leave) throws CustomException;

  /**
   * @param leave
   * @return
   * @throws CustomException
   */
  ReturnValue approveLeave(UserLeave leave) throws CustomException;

  /**
   * @param managerId
   * @return
   * @throws CustomException
   */
  List<UserLeave> getLeaves(Long managerId) throws CustomException;
}
