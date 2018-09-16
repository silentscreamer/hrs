package com.example.service;

import java.util.List;

import com.example.dto.ReturnValue;
import com.example.entity.Leaves;
import com.example.utils.CustomException;

public interface LeavesService {
	
	ReturnValue requestLeave(Leaves leave) throws CustomException;
	ReturnValue approveLeave(Leaves leave) throws CustomException;
	List<Leaves> getLeaves(int managerId) throws CustomException;
}
