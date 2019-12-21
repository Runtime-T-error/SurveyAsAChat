package com.runtimeterror.saac.service;

import com.runtimeterror.saac.controllers.SurveyDTO;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class DialogueService {


    @Async
    public void startSurvey(SurveyDTO surveyDTO) {
        
    }


}
