package com.userMgmt.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender jms;

	public Boolean sendEmail(String subject, String body, String to) {

		Boolean isSent = false;
		try {
			SimpleMailMessage msg = new SimpleMailMessage();
			msg.setTo(to);
			msg.setSubject(subject);
			msg.setText(body);

			jms.send(msg);
			isSent = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSent;

	}

}
