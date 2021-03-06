package com.gd.spring.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MailClientService {

    private JavaMailSender mailSender;
    private final MailContentBuilderService mailContentBuilder;

    @Value("${spring.mail.mock}")
    private Boolean mock;

    @Autowired
    public MailClientService(JavaMailSender mailSender, MailContentBuilderService mailContentBuilder) {
        this.mailSender = mailSender;
        this.mailContentBuilder = mailContentBuilder;
    }

    public void prepareAndSend(String recipient, String message) {
        MimeMessagePreparator messagePreparator = mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setFrom("sender@domain.com");
            messageHelper.setTo(recipient);
            messageHelper.setSubject("Sample mail subject");
            // If we want to send a simple text message use this method.
            // messageHelper.setText(message);
            // If we want to send a html email then do this. THis uses a thymeleaf template.
            String content = mailContentBuilder.build(message);
            messageHelper.setText(content, true);
        };

        try {
            if (!mock) {
                mailSender.send(messagePreparator);
                log.info("Mail SENT to {} with text: {}", recipient, message);
            } else {
                log.info("Mail SENT(mock) to {} with text: {}", recipient, message);
            }
        } catch (MailException e) {
            // runtime exception; compiler will not force you to handle it
            log.error("Mail FAILED to {} with text: {}.Exception: {}", recipient, message, e);
        }
    }

}
