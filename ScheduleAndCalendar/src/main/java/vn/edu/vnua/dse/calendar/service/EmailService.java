package vn.edu.vnua.dse.calendar.service;

import org.springframework.mail.SimpleMailMessage;

public interface EmailService {
	public void sendEmail(SimpleMailMessage email);
}
