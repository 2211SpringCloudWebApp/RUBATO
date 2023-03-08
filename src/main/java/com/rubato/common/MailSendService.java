package com.rubato.common;

import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class MailSendService {
	@Autowired
	private JavaMailSenderImpl mailSender;
	
	private int makeRandomCode() {
		Random rand = new Random();
		int randomCode = rand.nextInt(888888)+111111;
		return randomCode;
	}
	
	public String registerEmail(String email) {
		int code = makeRandomCode();
		String sender = "roovies.test23@gmail.com";
		String receiver = email;
		String title = "[루바토] 회원가입을 위한 인증코드입니다.";
		String content =
				"<h1>루바토 회원가입을 진심으로 환영합니다.</h1>"+
				"<h4>회원가입을 위한 인증코드는 <b><mark>"+code+"</b></mark>입니다.</h4>"+
				"인증번호를 인증번호 입력칸에 기입해주세요.";
		mailSend(sender, receiver, title, content);
		return Integer.toString(code);
		
	}
	
	public void mailSend(String sender, String receiver, String title, String content) {
		MimeMessage message = mailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
			helper.setFrom(sender);
			helper.setTo(receiver);
			helper.setSubject(title);
			helper.setText(content, true);
			mailSender.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
	}
	
}
