package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.entity.Leaves;

@Repository
public interface LeavesRepository extends JpaRepository<Leaves, Integer>{

	 @Query(value = "SELECT * from LEAVES WHERE approver_id = ?1", nativeQuery = true)
	  List<Leaves> getLeavesForaManager(int managerId);
}
