package com.userMgmt.Service;

import java.util.Map;

import com.userMgmt.DTO.User;
public interface UserMgmtService {
	
	/**Registration page methods**/
	
	//To get dropdown values for state based on country
	public Map<Integer,String> findCountries();
	public Map<Integer,String> findStates(Integer countryId);
	public Map<Integer,String> findCities(Integer stateId);
	
	//To check unique email id
	public Boolean isEmailExists(String emailId);
	
	//To register user details
	public Boolean saveUserDetails(User user);
	
	/**Login Page methods**/
	
	//To check Account Status 
	public String validateCredentials(String email,String password);
	
	
	/**Unlock Account methods**/
	//we can write in a single method by passing email,tempPwd and newPwd
	
	//To get existing password
	public Boolean isTempPasswordValid(String email,String tempPwd) ;
	//To update the temp password with new pwd
	public Boolean unlockAccount(String email,String newPassword);
	
	
	/** Forgot Password **/
	
	public String forgotPassword(String email);

}
