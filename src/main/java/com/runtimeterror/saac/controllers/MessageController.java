package com.runtimeterror.saac.controllers;

import com.runtimeterror.saac.dto.MessageResponse;
import com.runtimeterror.saac.service.Cache;
import com.runtimeterror.saac.service.DialogueService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
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
        final Long dialogueId = Cache.SESSION.get(msg.getRecipientId());
        if (StringUtils.isEmpty(dialogueId)) {
            log.error("No dialoge id found for recipient {}", msg.getRecipientId());
            return ResponseEntity.badRequest().build();
        }
        executors.submit(() -> dialogueService.handleSurveyResponse(msg.getResponse(), dialogueId));
        return ResponseEntity.ok().build();
    }
}

