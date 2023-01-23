package kg.mega.saloon.service;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.Date;

public interface EmailSenderService {
    void sendEmail(String email,String name, Date appointmentDate, int confirmCode) throws IOException, MessagingException;
}
