package com.runtimeterror.saac.controllers;

import com.runtimeterror.saac.service.SurveyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "surveys")
public class SurveyController {

    private static final Logger logger = LoggerFactory.getLogger(SurveyController.class);

    private SurveyService surveyService;

    public SurveyController(SurveyService surveyService) {
        this.surveyService = surveyService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> startSurvey(@RequestBody SurveyDTO surveyDTO) {
        logger.info(surveyDTO.toString());
        if (StringUtils.isEmpty(surveyDTO.getSurveyId()) || StringUtils.isEmpty(surveyDTO.getUserId())){
            logger.error("SurveyId or UserId is missing.");
            return ResponseEntity.badRequest().build();
        }

        if (surveyService.startSurvey(surveyDTO)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().body("");
    }

}
