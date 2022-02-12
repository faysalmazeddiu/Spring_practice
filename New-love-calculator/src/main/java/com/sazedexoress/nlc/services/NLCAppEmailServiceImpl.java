package com.sazedexoress.nlc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@Service
public class NLCAppEmailServiceImpl implements NLCAppEmailService{

	@Autowired
	private JavaMailSender javaMailSender;
	
	
	@Override
	public void sendEmail(String userName,String emailAddress, String result) {
		
		SimpleMailMessage newEmail= new SimpleMailMessage();
		newEmail.setTo(emailAddress);
		newEmail.setSubject("LOVE CALVULATOR APP RESULT");
		newEmail.setText("Hi "+userName+" the result predicted by the LCApp is "+result);
		javaMailSender.send(newEmail);
		
	}

}
