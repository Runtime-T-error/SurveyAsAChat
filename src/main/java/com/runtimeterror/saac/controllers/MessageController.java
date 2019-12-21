package com.runtimeterror.saac.controllers;

import com.runtimeterror.saac.dto.MessageResponse;
import com.runtimeterror.saac.dto.SurveyItemMessage;
import com.runtimeterror.saac.responses.ErrorResponse;
import com.runtimeterror.saac.service.DialogueService;
import com.runtimeterror.saac.service.FacebookMessagingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
public class MessageController {
    private static Logger log = LoggerFactory.getLogger(MessageController.class);

    @Autowired
    private DialogueService dialogueService;

    @PostMapping("/message")
    public ResponseEntity receiveMessage(@RequestBody MessageResponse msg) {
        return ResponseEntity.ok().build();
    }
}

