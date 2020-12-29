package com.userMgmt.DTO;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "USER_DETAILS")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="SID")
	public Integer SID;
	@Column(name="EMAIL")
	public String email;
	@Column(name="FIRST_NAME")
	public String firstName;
	@Column(name="LAST_NAME")
	public String lastName;
	@Column(name="PHONE_NUMBER")
	public String phoneNo;
	@Column(name="DOB")
	public Date DOB;
	@Column(name="GENDER")
	public String gender;
	@Column(name="COUNTRY")
	public String country;
	@Column(name="STATE")
	public String state;
	@Column(name="CITY")
	public String city;
	
	@Column(name="PASSWORD")
	public String password;
	
	@Column(name="ACCOUNT_STATUS")
	public String accountStatus;
}
