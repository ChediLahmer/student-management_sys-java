package com.example.dualist;
import javax.mail.internet.*;
import javax.mail.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.lang.reflect.InvocationTargetException;
import java.util.Properties;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mail {
    private String username = "george@cerone@gmail.com";
    private String password = "passwordrandom123";
    @FXML
    private Button bsubmit;
    @FXML
    private TextField badress;

    @FXML
    private TextField bobject;
    @FXML
    private TextField bbody;

    @FXML
    void insertadress(ActionEvent event) {

    }

    @FXML
    void insertobject(ActionEvent event) {

    }
    @FXML
    void submit(ActionEvent event) {
        try {
            String to = badress.getText();
            String subject = bobject.getText();
            String body = bbody.getText();

            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");

            Session session = Session.getInstance(props,
                    new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication("chedi.lahmer@gmail.com", "3345wael20");
                        }
                    });

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("chedi.lahmer@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(body);

            Transport.send(message);
        } catch (AddressException e) {
            throw new RuntimeException(e);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }

    }





