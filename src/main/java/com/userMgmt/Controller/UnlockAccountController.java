package com.userMgmt.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.userMgmt.Service.UserMgmtService;

@RestController
public class UnlockAccountController {
	
	@Autowired
	public UserMgmtService userMgmtService;
	
	@GetMapping(value="/unlock")
	public ResponseEntity<String> unlockAccount(@PathVariable("email") String email,@PathVariable("password") String newPassword) {
		String response = null;
		
		Boolean msg = userMgmtService.unlockAccount(email, newPassword);
		
		if(msg==true) {
			response = "Account unlocked, please proceed with login";
			return new ResponseEntity<String>(response, HttpStatus.OK);
		}else

			return new ResponseEntity<String>(response, HttpStatus.CONFLICT);
	}
	
}
