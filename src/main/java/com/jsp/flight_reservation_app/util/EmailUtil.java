package com.jsp.flight_reservation_app.util;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailUtil {

	@Autowired
	private JavaMailSender javaMailSender;

	public void sendTicketsEmail(String toAddress, String subject, String text, String attachment, String filePath) {

		MimeMessage message = javaMailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true);

			helper.setTo(toAddress);
			helper.setSubject(subject);
			helper.setText(text);

//			 Attach the PDF file
			FileSystemResource file = new FileSystemResource(filePath);
			helper.addAttachment(attachment, file);

			javaMailSender.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
