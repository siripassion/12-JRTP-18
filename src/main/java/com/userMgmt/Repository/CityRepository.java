package com.userMgmt.Repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.userMgmt.DTO.City;

public interface CityRepository extends JpaRepository<City,Serializable>{
	
	public List<City> findByStateId(Integer stateId);
}
