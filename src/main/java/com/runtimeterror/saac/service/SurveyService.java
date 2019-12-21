package com.runtimeterror.saac.service;

import com.runtimeterror.saac.controllers.SurveyDTO;
import org.springframework.stereotype.Component;

@Component
public class SurveyService {

    private final DialogueService dialogueService;

    public SurveyService(DialogueService dialogueService) {
        this.dialogueService = dialogueService;
    }

    public void startSurvey(SurveyDTO surveyDTO) {
        dialogueService.startSurvey(surveyDTO);
    }
}
