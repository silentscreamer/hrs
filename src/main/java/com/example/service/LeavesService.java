package com.example.service;

import com.example.dto.ReturnValue;
import com.example.entity.Leaves;

public interface LeavesService {
	
	ReturnValue requestLeave(Leaves leave);

}
