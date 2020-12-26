package com.userMgmt.DTO;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Country {
@Id
@Column(name="COUNTRY_ID")
public Integer countryId;
@Column(name="COUNTRY_NAME")
public String countryName;
@Column(name="COUNTRY_CODE")
public String countryCode;

//public List<State> statesList;

}
