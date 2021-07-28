package com.samuelDev.sendEmail.controller;

import com.samuelDev.sendEmail.domain.Email;
import com.samuelDev.sendEmail.dtos.EmailDtoPost;
import com.samuelDev.sendEmail.mapper.EmailMapper;
import com.samuelDev.sendEmail.services.EmailServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/email")
public class EmailController {

    private final EmailServices emailServices;

    @GetMapping
    public ResponseEntity<List<Email>> getAllEmails(){
        return new ResponseEntity<>(emailServices.getAllEmails(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Email> listEmail(@RequestBody @Valid EmailDtoPost emailDtoPost) {
        Email email = EmailMapper.INSTANCE.toEmail(emailDtoPost);
        emailServices.sendEmailOrThrowBadRequestException(email);
        return new ResponseEntity<>(email, HttpStatus.CREATED);
    }
}
