package com.userMgmt.Repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.userMgmt.DTO.State;

public interface StateRepository extends JpaRepository<State, Serializable>{

	public List<State> findByCountryId(Integer countryId);
}
