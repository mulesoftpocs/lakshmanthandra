package com.Spring.email;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Spring.email.dto.MailRequest;
import com.Spring.email.dto.MailResponse;
import com.Spring.email.service.EmailService;

@SpringBootApplication
@RestController

public class SendingMailApplication {
	
	

	public static void main(String[] args) {
		SpringApplication.run(SendingMailApplication.class, args);
 }
	@Autowired
	private EmailService service;
	
	@RequestMapping("/sendEmail")
	public MailResponse sendEmail(@RequestBody MailRequest request) {
		Map<String, Object> model= new HashMap<>();
		model.put("Name", request.getName());
		model.put("location", "hyderabad, India");
		return service.sendEmail(request, model);
		
	}
	
	
}


