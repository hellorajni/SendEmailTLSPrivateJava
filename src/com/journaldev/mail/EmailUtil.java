
package com.journaldev.mail;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EmailUtil {

	/**
	 * Utility method to send simple HTML email
	 * @param session
	 * @param toEmail
	 * @param ccEmail
	 * @param bccEmail
	 * @param subject
	 * @param body
	 */
	public static void sendEmail(Session session, String toEmail, String ccEmail,String bccEmail, String subject, String body){
		try
	    {
	      MimeMessage msg = new MimeMessage(session);
	      //set message headers
	      msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
	      msg.addHeader("format", "flowed");
	      msg.addHeader("Content-Transfer-Encoding", "8bit");

	      msg.setFrom(new InternetAddress("no_reply@example.com", "NoReply-JD"));

	      msg.setReplyTo(InternetAddress.parse("no_reply@example.com", false));

	      msg.setSubject(subject, "UTF-8");

	      msg.setText(body, "UTF-8");

	      msg.setSentDate(new Date());

	      msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
	      if(ccEmail != null){
	    	  msg.setRecipients(Message.RecipientType.CC, InternetAddress.parse(ccEmail, false));
	      }
	      if(bccEmail != null){
	    	  msg.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(bccEmail, false));
	      }
	      
	      System.out.println("Message is ready");
    	  Transport.send(msg);  

	      System.out.println("EMail Sent Successfully!!");
	    }
	    catch (Exception e) {
	      e.printStackTrace();
	    }
	}
	
	/**
	 * Removes incorrect email ids and incorrect domain email ids
	 * @param emailIds
	 * @param domain
	 */
	public static String FilterEmailIdByDomain(String emailIds, String domain)
	{
		String result = "";
		
		String[] ids = emailIds.split(",");
		if (ids.length >0)
		{
			for(String id : ids)
			{
				id = id.trim();
				String emailRegex = "[a-zA-Z0-9_.+-]+" + domain.toLowerCase();
				if (java.util.regex.Pattern.matches(emailRegex, id.toLowerCase()))
				{
					result += id + ",";
				}
			}
			//we can remove last comma if you want, but it works..
		}
		return result;
	}
	
}
