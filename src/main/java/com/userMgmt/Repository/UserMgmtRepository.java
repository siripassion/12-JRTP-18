package com.userMgmt.Repository;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.userMgmt.DTO.User;

public interface UserMgmtRepository extends JpaRepository<User, Serializable>{
	
	public Optional<User> findByEmailAndPassword(String email,String password);

	public User findByEmail(String emailId);

}
