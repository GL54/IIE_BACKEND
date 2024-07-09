package com.iie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.iie.model.Examination;
import com.iie.repository.ExaminationRepository;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender emailSender;
	@Autowired
	private ExaminationRepository examinationRepository;

	public void sendSimpleMessage(String to, String subject, String text) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("sheethu0001@gmail.com");
		message.setTo(to);
		message.setSubject(subject);
		message.setText(text);
		emailSender.send(message);
	}

	public Examination examDateMail(Examination examination) {
		// Save the examination object
		Examination savedExamination = examinationRepository.save(examination);

		// Prepare email
		String to = "sheethu0001@gmail.com";
		String subject = "New Exam Form Submission";
		String text = "New Exam form submission received:\n" + "Name: " + examination.getName() + "\n"
				+ "Application Number: " + examination.getApplicationNumber() + "\n" + "Course: "
				+ examination.getCourse() + "\n" + "Stream: " + examination.getStream() + "\n" + "Examination Date: "
				+ examination.getExamDate();

		// Send email
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("sheethu0001@gmail.com");
		message.setTo(to);
		message.setSubject(subject);
		message.setText(text);
		emailSender.send(message);

		return savedExamination;

	}
	   public EmailService(JavaMailSender emailSender) {
	        this.emailSender = emailSender;
	    }

	    public void sendApplicationEmail(String to, String subject, String content) {
	        SimpleMailMessage message = new SimpleMailMessage();
	        message.setTo(to);
	        message.setSubject(subject);
	        message.setText(content);
	        emailSender.send(message);
	    }
}
