package Controller;


import javax.mail.*;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendMail {

    public static void main(String[] args) throws MessagingException {

        System.out.println("-- Starting procedure of Sending mail ---");

        Properties properties=new Properties();
        properties.setProperty("mail.host","smtp.gmail.com");
        properties.setProperty("mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.smtp.port","587");
        properties.setProperty("mail.smtp.auth","true");


                Authenticator authenticator=new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("anomalia2016@gmail.com","donald79");
            }
        };

    Session session=Session.getDefaultInstance(properties,authenticator);

    Message message=new MimeMessage(session);

    message.setSubject("Witaj witaj");
    message.setText("aaaaaaaaaaaaaaaaa");
    message.setFrom(new InternetAddress("123@wp.pl"));

    message.setRecipient(Message.RecipientType.TO,new InternetAddress("anomalia2016@gmail.com"));
    Transport.send(message);
        System.out.println("Succces: Mail sent!");
        System.out.println("==============================================");
    }






}
