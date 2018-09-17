package com.example.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.entity.UserLeave;

@Repository
public interface LeavesRepository extends JpaRepository<UserLeave, Long> {

  @Query(value = "SELECT * from USER_LEAVE WHERE approver_id = ?1", nativeQuery = true)
  List<UserLeave> getLeavesForaManager(Long managerId);
}
