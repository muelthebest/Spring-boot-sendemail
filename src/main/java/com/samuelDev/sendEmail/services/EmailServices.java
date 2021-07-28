package com.samuelDev.sendEmail.services;

import com.samuelDev.sendEmail.domain.Email;
import com.samuelDev.sendEmail.enums.StatusEmail;
import com.samuelDev.sendEmail.exceptions.BadRequestException;
import com.samuelDev.sendEmail.repository.EmailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmailServices {

    private final EmailRepository emailRepository;

    private final JavaMailSender mailSender;

    public List<Email> getAllEmails(){
        return emailRepository.findAll();
    }

    public Email sendEmailOrThrowBadRequestException(Email email) {
        email.setSendDateEmail(LocalDateTime.now());
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(email.getEmailFrom());
            message.setTo(email.getEmailTo());
            message.setSubject(email.getSubject());
            message.setText(email.getText());
            mailSender.send(message);

            email.setStatusEmail(StatusEmail.SENT);
        } catch (BadRequestException e) {
            email.setStatusEmail(StatusEmail.ERROR);
        }

        return emailRepository.save(email);
    }
}
