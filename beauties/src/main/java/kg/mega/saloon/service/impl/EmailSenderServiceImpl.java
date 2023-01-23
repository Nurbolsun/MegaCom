package kg.mega.saloon.service.impl;

import kg.mega.saloon.network.EmailSender;
import kg.mega.saloon.service.EmailSenderService;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

@Service
public class EmailSenderServiceImpl implements EmailSenderService {

    @Override
    public void sendEmail(String email,String name, Date appointmentDate, int confirmCode) throws IOException, MessagingException {
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm");

        final Properties properties = new Properties();
        properties.load(EmailSender.class.getClassLoader().getResourceAsStream("application.properties"));

        Session mailSession = Session.getDefaultInstance(properties);
        MimeMessage message = new MimeMessage(mailSession);
        message.setFrom(new InternetAddress("kg.nurbo.97@gmail.com"));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
        message.setSubject("Подтверждение записи");
        message.setText("Здравствуйте " + name + "," + "Вы записались на дату " + dateFormat.format(appointmentDate) + " . " +
                "Ваш код заявки " + confirmCode + ". Просим подтвердить высланный Вам код в течении часа, в " +
                "противном случае ваша заявка будет удалена. Спасибо! ");

        Transport transport = mailSession.getTransport();
        transport.connect(null, "gnjgwmnqfdidwwzc");
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }
}
