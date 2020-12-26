package com.userMgmt.DTO;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class State {
	@Id
	@Column(name="STATE_ID")
	public Integer stateId;
	@Column(name="STATE_NAME")
	public String stateName;
	
//	public List<City> cityList;

}
