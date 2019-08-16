package email;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EnviaEmail {

	private String emailDestinatario;

	private String assunto;
	private String msg;

	public String getEmailDestinatario() {
		return emailDestinatario;
	}

	public void setEmailDestinatario(String emailDestinatario) {
		this.emailDestinatario = emailDestinatario;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public boolean Gmail() {
		boolean retorno = false;

		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("hiiammaowss@gmail.com", "123456");
			}
		});
		
		session.setDebug(true);
		
		/*try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("hiiammaowss@gmail.com"));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(this.emailDestinatario));

            message.setSubject(this.assunto);
            message.setContent(this.msg, "text/html; charset=utf-8");

            //send message  
            Transport.send(message);

            retorno = true;

        } catch (MessagingException e) {
            retorno = false;
            e.printStackTrace();
        }*/
		
		try {
			 
		      Message message = new MimeMessage(session);
		      message.setFrom(new InternetAddress("seuemail@gmail.com")); 
		      //Remetente
		 
		      Address[] toUser = InternetAddress //Destinatário(s)
		                 .parse("thierryiago@gmail.com, seucolega@hotmail.com, seuparente@yahoo.com.br");  
		 
		      message.setRecipients(Message.RecipientType.TO, toUser);
		      message.setSubject("Enviando email com JavaMail");//Assunto
		      message.setText("Enviei este email utilizando JavaMail com minha conta GMail!");
		      /**Método para enviar a mensagem criada*/
		      Transport.send(message);
		 
		      System.out.println("Feito!!!");
		 
		     } catch (MessagingException e) {
		        throw new RuntimeException(e);
		    }

		return retorno;
	}
}
