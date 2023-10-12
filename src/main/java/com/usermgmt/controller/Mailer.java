package com.usermgmt.controller;


import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.PasswordAuthentication;



	  
	public class Mailer {  
	public static void send(String to,String subject,String msg){  
	  
	final String user="arishidivya@gmail.com";//change accordingly  
	final String pass="bkeo jsui zufa szyx";  
	

	//1st step) Get the session object    
	//Properties props = new Properties();  
	//System.setProperty("java.net.preferIPv4Stack", "true") ;
	Properties props = System.getProperties();
	//props.put("mail.smtp.host", "smtp.office365.com");//change accordingly  
	 props.put("mail.smtp.host", "smtp.gmail.com");
	//props.put("mail.smtp.auth", "true"); 
	props.put("mail.smtp.starttls.enable", "true");
	 props.put("mail.smtp.port", "587");
	 //props.put("mail.smtp.starttls.required", "true");
	// props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
	  
	Session session = Session.getDefaultInstance(props,  
	 new javax.mail.Authenticator() {  
	  protected PasswordAuthentication getPasswordAuthentication() {  
	   return new PasswordAuthentication(user,pass);  
	   }  
	});  
	//2nd step)compose message  
	try {  
	 MimeMessage message = new MimeMessage(session);  
	 message.setFrom(new InternetAddress(user));  
	 message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
	 message.setSubject(subject);  
	 message.setText(msg);  
	   
	 //3rd step)send message  
	 Transport.send(message);
	  
	 System.out.println("Done");  
	  
	 } catch (MessagingException e) {  
	    throw new RuntimeException(e);  
	 }  
	      
	}  
	}  

