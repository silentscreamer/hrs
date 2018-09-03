package com.example.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.dto.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
}
