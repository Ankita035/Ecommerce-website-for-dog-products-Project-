package com.example.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.service.EmailService;

import jakarta.servlet.http.HttpSession;

@Controller
public class ForgotController {

	Random random = new Random(1000);
	
	@Autowired
	private EmailService emailService;
	
	@RequestMapping("/forgot")
	public String openEmailForm() {
		return "forgot_email_form";
	}
	
	@PostMapping("/sendotp")
	public String sendOTP(@RequestParam("email") String email, HttpSession session) {
		System.out.println("Email "+email);
		int otp = random.nextInt(999999);
		System.out.println("OTP "+otp);
		
		String subject = "OTP from Love Puppies";
		
		String message = "OTP for verification " + otp;
		
		String to = email;

		boolean flag = this.emailService.sendEmail(subject, message, to);
		
		if(flag) {
			return "change_password";
		}
		else {
			
			session.setAttribute("message", "Check your Email ID !!!");
			return "verify_otp";
		}
	
	}
}
