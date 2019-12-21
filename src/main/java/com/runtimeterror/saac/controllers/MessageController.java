package com.runtimeterror.saac.controllers;

import com.runtimeterror.saac.dto.MessageResponse;
import com.runtimeterror.saac.dto.SurveyItemMessage;
import com.runtimeterror.saac.model.Sequence;
import com.runtimeterror.saac.model.Sequences;
import com.runtimeterror.saac.responses.ErrorResponse;
import com.runtimeterror.saac.service.FacebookMessagingService;
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
    @Autowired
    private Sequences sequences;
    @Autowired
    private FacebookMessagingService fbMessages;

    @PostMapping("/message")
    public ResponseEntity receiveMessage(@RequestBody MessageResponse msg) {
        Sequence seq = sequences.getSequence(msg.getSequenceId());
        if(seq == null) return ResponseEntity.status(404).body(new ErrorResponse("NOT_FOUND", "Invalid sequenceId"));
        SurveyItemMessage item = seq.getCurrentItem();
        if(item.containsResponse(msg.getResponse())) {
            //save response
            if(seq.advancePosition()) return ResponseEntity.status(200).body(seq.getCurrentItem());
            else return ResponseEntity.status(200).body("");
        } else {
            return ResponseEntity.status(400).body(new ErrorResponse("INVALID_RESPONSE", "Wrong response received"));
        }
    }

    @PostMapping("/sequence")
    public ResponseEntity launchSequence(@RequestParam(value = "id", required = false) UUID sequenceId) {
        if(sequenceId == null) {
            Sequence seq = sequences.createRandomSequence(10);
            fbMessages.sendMessage(seq.getCurrentItem());
            return ResponseEntity.status(200).body("");
        }

        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body("");
    }
}
