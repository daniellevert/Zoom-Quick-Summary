package ZoomQuickSummary;


import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
  
  
public class SendEmail 
{
	
	SendEmail() {
		System.out.println("Constructor called");
	}
	/*
	 * Initializes email sending process
	 */
	public void sendEmail(String filePath) 
	{    
		ArrayList<String> recipients = createRecipientsList();
		
		// account and password strings
		final String emailAcct = "zoomquicksummary@gmail.com";
		final String emailPass = "mopvej-0tiFbi-negpaw"; // DON'T LET ANYONE SEE THIS
		
		Properties properties = new Properties();
		
		// setting up mail server
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		
		// creating session object to get properties  
		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(emailAcct, emailPass);
			}
		});
		
//		String filename = "meeting_saved_chat.txt"; // TODO: pass in filename from folder monitor code
		
		for (int i = 0; i < recipients.size(); i++) {
			Message message = prepareMessage(session, emailAcct, recipients.get(i), filePath);
			
			try {
				// send email
				Transport.send(message);
				System.out.println("Quick summary successfully sent to " + recipients.get(i));
			} catch (MessagingException e) {
				System.out.println("Quick summary failed to send for " + recipients.get(i));
				e.printStackTrace();
			}
		}
	}
	
	/*
	 * Allows users to input email recipients via command line.
	 * Can be used in modified form in the final, automated version, e.g.
	 * validate email addresses received from Zoom and add them to list.
	 */
	private static ArrayList<String> createRecipientsList() {
		System.out.println("Enter quick summary email recipients. Enter 'd' when done: ");
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		
		ArrayList<String> recipients = new ArrayList<String>();
		recipients.add("daniel.levert@morningstar.com");
		
		while (!input.equals("d")) {
			if (input.contains("@") && input.contains(".")) {
				recipients.add(input.toString());
				input = scanner.nextLine();
			}
			else {
				System.out.println("Invalid email address entered. Try again.");
				input = scanner.nextLine();
			}
		}
		
		scanner.close();
		
		return recipients;
	}
	
	/*
	 * Creates message with body and chat history .txt attachment
	 */
	private static Message prepareMessage(Session session, String emailAcct, String recipient, String filename) {
		try 
		{
			MimeMessage message = new MimeMessage(session);
			
			message.setFrom(new InternetAddress(emailAcct));
			
			// TODO: decide if we should change RecipientType to .CC or .BCC
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
			
			message.setSubject("Zoom Quick Summary");
			
			/* 
			 * Setting text and attachment content for the email 
			 */
			BodyPart textBodyPart = new MimeBodyPart();
			textBodyPart.setText("Dear " + recipient + ",\n\nAttached is the chat history from your recent Zoom meeting, brought to you by some really cool Morningstar interns.\n\nEnjoy!\nZoom Quick Summary Team\n");
			
			// TODO: where Zoom chat history filename with path will be attached
			BodyPart attachmentBodyPart = new MimeBodyPart(); 
			DataSource source = new FileDataSource(filename);  
			attachmentBodyPart.setDataHandler(new DataHandler(source));  
			attachmentBodyPart.setFileName(filename);  
			  
			// puts text and attachment parts of the email together
			Multipart multipartObject = new MimeMultipart();  
			multipartObject.addBodyPart(textBodyPart);  
			multipartObject.addBodyPart(attachmentBodyPart);
			
			message.setContent(multipartObject);
			
			return message; // prepared message to be sent
		}
		catch (MessagingException e) 
		{
			e.printStackTrace();
		}
		return null;
	}
}