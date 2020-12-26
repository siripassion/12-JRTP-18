package com.userMgmt.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.userMgmt.DTO.User;
import com.userMgmt.Service.UserMgmtService;

@RestController
public class UserMgmtController {
	
	@Autowired
	public UserMgmtService userMgmtService;
	
	@PostMapping(value="/register")
	public ResponseEntity<String> addUser(@RequestBody User user) {
		String responseMsg = null;
		
		Boolean msg = userMgmtService.saveUserDetails(user);
		
		if(msg==true) {
			 responseMsg = "User Info saved successfully!!!";
		}else
			responseMsg = "Failed to save user info!!!";
		
	    return new ResponseEntity<String>(responseMsg,HttpStatus.CREATED);
   }
	
	
	
	 
}
