package Controller;


import javax.mail.*;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendMail {

    public static void main(String[] args) throws MessagingException {
        Properties properties=new Properties();
        properties.setProperty("mail.host","smtp.gmail.com");
        properties.setProperty("mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.smtp.port","587");
        properties.setProperty("mail.smtp.auth","true");
                Authenticator authenticator=new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("fxproject.info@gmail.com","fxproject2017");
            }
        };
    Session session=Session.getDefaultInstance(properties,authenticator);
    Message message=new MimeMessage(session);
    message.setSubject("Witaj witaj");
    message.setText("Test message");
    message.setFrom(new InternetAddress("123@wp.pl"));
    message.setRecipient(Message.RecipientType.TO,new InternetAddress("fxproject.info@gmail.com"));
    Transport.send(message);
        System.out.println("Succces: Mail sent!");
    }
}
