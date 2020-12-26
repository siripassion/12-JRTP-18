package com.userMgmt.Repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.userMgmt.DTO.State;

public interface StateRepository extends JpaRepository<State, Serializable>{

}
