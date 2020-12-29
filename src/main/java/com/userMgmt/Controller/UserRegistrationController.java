package com.userMgmt.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.userMgmt.DTO.User;
import com.userMgmt.Service.UserMgmtService;

@RestController
public class UserRegistrationController {
	
	@Autowired
	public UserMgmtService userMgmtService;
	
	@GetMapping(value="/countries")
	public Map<Integer, String> findCountries() {
		 
		Map<Integer, String> countryMap = userMgmtService.findCountries();
			
		return countryMap;
	}
	
	@GetMapping(value="/states/{countryId}")
	public Map<Integer, String> findStates(@PathVariable Integer countryId) {
		 
		Map<Integer, String> statesMap = userMgmtService.findStates(countryId);
			
		return statesMap;
	}
	
	@GetMapping(value="/cities/{stateId}")
	public Map<Integer, String> findCities(@PathVariable Integer stateId) {
		 
		Map<Integer, String> citiesMap = userMgmtService.findCities(stateId);
			
		return citiesMap;
	}
	
	@GetMapping(value="/emailUnique/{email}")
	public String isEmailUnique(@PathVariable String email) {
		if(userMgmtService.isEmailExists(email)) {
			return "DUPLICATE";
		}else
			return "UNIQUE";
		
	}
	
	@PostMapping(value="/register",consumes = "application/json")
	public ResponseEntity<String> addUser(@RequestBody User user) {
		String responseMsg = null;
		
		Boolean msg = userMgmtService.saveUserDetails(user);
		
		if(msg==true) {
			 responseMsg = "User Info saved successfully!!!";
				
			 return new ResponseEntity<String>(responseMsg,HttpStatus.CREATED);
		}else {
			responseMsg = "Failed to save user info!!!";
			
		    return new ResponseEntity<String>(responseMsg,HttpStatus.BAD_REQUEST);
		}
			
   }
	
	
	
	 
}
