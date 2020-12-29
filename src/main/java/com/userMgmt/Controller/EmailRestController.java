package com.userMgmt.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userMgmt.Service.EmailService;

@RestController
public class EmailRestController {
	
	@Autowired
	private EmailService ems;
	
	@GetMapping("/send")
	public String sendMail() {
		String subject = "Test mail";
		String body="Hello siri";
		String to = "siripassion2020@gmail.com";
		boolean isSent = ems.sendEmail(subject, body, to);
		if(isSent)
			return "mail sent successfully";
		else
			return "failed to sent mail";
		
	}

}
