package com.userMgmt.DTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class City {
	@Id
	@Column(name="CITY_Id")
	public Integer cityId;
	@Column(name="CITY_NAME")
	public String cityName;
	@Column(name="STATE_ID")
	public Integer stateId;

}
