package main.java.com.techies.irecruiter.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import main.java.com.techies.irecruiter.dataobject.EmailDO;
import org.springframework.stereotype.Component;
@Component
public class EmailUtil {
	Properties props = null;
	public EmailUtil(){
		
		props = new Properties();
		 props = new Properties();
	      props.put("mail.smtp.auth", "true");
	      props.put("mail.smtp.starttls.enable", "true");
	      props.put("mail.smtp.host",  "smtp.gmail.com");
	      props.put("mail.smtp.port", "587");
	}
	public boolean sendEmail(EmailDO emailDO)
	{
		boolean status = true;
		final String userName = emailDO.getUserName();
		final String password = emailDO.getPassword();
		
		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				
				return new PasswordAuthentication(userName, password);
			}
			
		});
		try{
			
			Message message = new MimeMessage(session);
			
			message.setFrom(new InternetAddress(emailDO.getFrom()));
			
			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(emailDO.getTo()));
			
			message.setSubject(emailDO.getSubject());
			
			message.setText(emailDO.getMessageContent());
			
			Transport.send(message);
			
			System.out.println("Send msg successfuly....");
			
		}catch (MessagingException e) {
			System.out.println("error:"+e.toString());
			
			status = false;
			
			throw new RuntimeException(e);
			// TODO: handle exception
		}
		return status;
	}

}
