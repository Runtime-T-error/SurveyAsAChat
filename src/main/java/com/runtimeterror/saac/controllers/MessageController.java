package com.runtimeterror.saac.controllers;

import com.runtimeterror.saac.dto.MessageResponse;
import com.runtimeterror.saac.service.DialogueService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
@RequestMapping("messages")
public class MessageController {
    private static Logger log = LoggerFactory.getLogger(MessageController.class);

    @Autowired
    private DialogueService dialogueService;

    private ExecutorService executors = Executors.newFixedThreadPool(100);

    @PostMapping("callback")
    public ResponseEntity<?> receiveMessageFromConnector(@RequestBody MessageResponse msg) {
        executors.submit(() -> dialogueService.handleSurveyResponse(msg.getResponse(), msg.getDialogueId()));
        return ResponseEntity.ok().build();
    }
}

