package tn.esprit.msreservation.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import tn.esprit.msreservation.Entities.Reservation;

@Service
public class NotificationService {
    private final JavaMailSender javaMailSender;

    @Autowired
    public NotificationService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendConfirmationEmail(Reservation reservation) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(reservation.getEmail());
        message.setSubject("Confirmation de réservation de voiture");
        message.setText("Votre réservation a été confirmée. Détails : " + reservation.toString());

        javaMailSender.send(message);
    }
}

