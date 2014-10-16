package com.gfs.erm.util;

import javax.mail.PasswordAuthentication;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.gfs.erm.web.common.WebConstants;

public class Mailer {
	private String senderEmail = "atonu.ganguly2014@gmail.com";
	 private String senderMailPassword = "a";
    private String host = "smtp.gmail.com";
    private String protocol = "smtp";
    //private String host = "merinoindia.com";
    private int port=465;
    
   public void send(String recipeintEmail, 
           String subject, 
           String messageText, 
           String []attachments) 
           throws MessagingException, AddressException {
       /*
          It is a good practice to put this in a java.util.Properties 
          file and encrypt password. Scroll down 
          to comments below to see 
          how to use java.util.Properties in JSF context. 
       */
      
        
       Properties props = System.getProperties();

       props.put("mail.smtp.user", senderEmail);
       props.put("mail.smtp.host", host);
       props.put("mail.smtp.port", port);
       props.put("mail.smtp.starttls.enable", "true");
       props.put("mail.smtp.debug", "true");
       props.put("mail.smtp.auth", "true");
       props.put("mail.smtp.socketFactory.port", port);
       props.put("mail.smtp.socketFactory.class", 
             "javax.net.ssl.SSLSocketFactory");
       props.put("mail.smtp.socketFactory.fallback", "false");

       // Required to avoid security exception.
       MyAuthenticator authentication = 
             new MyAuthenticator(senderEmail,senderMailPassword);
       Session session = 
             Session.getDefaultInstance(props,authentication);
       session.setDebug(true);

       MimeMessage message = new MimeMessage(session);
        
       BodyPart messageBodyPart = new MimeBodyPart();      
       messageBodyPart.setText(messageText);
        
       // Add message text
       Multipart multipart = new MimeMultipart();
       multipart.addBodyPart(messageBodyPart);
        
       // Attachments should reside in your server.
       // Example "c:\file.txt" or "/home/user/photo.jpg"

       for (int i=0; i < attachments.length; i++) {        
           messageBodyPart = new MimeBodyPart();       
           DataSource source = new FileDataSource(attachments[i]);
           messageBodyPart.setDataHandler(new DataHandler(source));
           messageBodyPart.setFileName(attachments [i]);          
           multipart.addBodyPart(messageBodyPart) ;  
       }
        
   
           
       message.setContent(multipart);                
       message.setSubject(subject);
       message.setFrom(new InternetAddress(senderEmail));
       message.addRecipient(Message.RecipientType.TO,new InternetAddress(recipeintEmail));
       message.setRecipients(Message.RecipientType.CC,InternetAddress.parse(WebConstants.AdminMail));
       
       Transport transport = session.getTransport("smtps");
       transport.connect(host,port, senderEmail, senderMailPassword);
       transport.sendMessage(message, message.getAllRecipients());
        
       transport.close();
        
   }
   
   public void send(String recipeintEmail, 
           String subject, 
           String messageText) 
           throws MessagingException, AddressException {
       /*
          It is a good practice to put this in a java.util.Properties 
          file and encrypt password. Scroll down 
          to comments below to see 
          how to use java.util.Properties in JSF context. 
       */
       Properties props = System.getProperties();
       props.put("mail.smtp.user", senderEmail);
       props.put("mail.smtp.password", senderMailPassword);
       props.put("mail.smtp.protocol", protocol);
       props.put("mail.smtp.host", host);
       props.put("mail.smtp.port", port);
       props.put("mail.smtp.starttls.enable","false");
       props.put("mail.smtp.auth", "false");
       props.put("mail.smtp.socketFactory.port", port);
       props.put("mail.smtp.socketFactory.class", "");
       props.put("mail.smtp.socketFactory.fallback", "false");
       //props.put("mail.smtp.ssl.enable", "false");
       // Required to avoid security exception.
       MyAuthenticator authentication =  new MyAuthenticator(senderEmail,senderMailPassword);
       Session session =  Session.getDefaultInstance(props,authentication);
       //Session session =  Session.getDefaultInstance(props);
       session.setDebug(true);
       
       Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(senderEmail));
		message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(recipeintEmail));
		//message.setRecipients(Message.RecipientType.CC,InternetAddress.parse(IMSSynchConstants.AdminMail));
		message.setSubject(subject);
		message.setContent(messageText, "text/html; charset=utf-8");
		//message.setText(messageText);

		Transport.send(message);
   }
    
   private class MyAuthenticator extends javax.mail.Authenticator {
       String User;
       String Password;
       public MyAuthenticator (String user, String password) {
           User = user;
           Password = password;
       }
        
       @Override
       public PasswordAuthentication getPasswordAuthentication() {
           return new javax.mail.PasswordAuthentication(User, Password);
       }
   }
    
}
   
   
  
