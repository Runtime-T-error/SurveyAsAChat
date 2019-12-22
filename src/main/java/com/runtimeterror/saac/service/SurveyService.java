package com.runtimeterror.saac.service;

import com.runtimeterror.saac.controllers.SurveyDTO;
import com.runtimeterror.saac.model.bot.Dialogue;
import com.runtimeterror.saac.model.bot.Survey;
import com.runtimeterror.saac.model.def.User;
import com.runtimeterror.saac.repositories.DialogueDAO;
import com.runtimeterror.saac.repositories.DialogueRepository;
import com.runtimeterror.saac.repositories.SurveyRepository;
import com.runtimeterror.saac.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class SurveyService {

    private static final Logger logger = LoggerFactory.getLogger(SurveyService.class);

    private final DialogueService dialogueService;
    private final UserRepository userRepository;
    private final SurveyRepository surveyRepository;
    private final DialogueRepository dialogueRepository;
    private final DialogueDAO dialogueDAO;

    private ExecutorService executors = Executors.newFixedThreadPool(100);

    public SurveyService(DialogueService dialogueService, UserRepository userRepository, SurveyRepository surveyRepository, DialogueRepository dialogueRepository, DialogueDAO dialogueDAO) {
        this.dialogueService = dialogueService;
        this.userRepository = userRepository;
        this.surveyRepository = surveyRepository;
        this.dialogueRepository = dialogueRepository;
        this.dialogueDAO = dialogueDAO;
    }

    @Transactional
    public boolean startSurvey(SurveyDTO surveyDTO) {

        User user = userRepository.findById(surveyDTO.getUserId())
                .orElse(null);
        if (user == null) {
            logger.error("Unable to find user " + surveyDTO.getUserId());
            return false;
        }

        Survey survey = surveyRepository.findById(surveyDTO.getSurveyId())
                .orElse(null);

        if (survey == null) {
            logger.error("Unable to find survey " + surveyDTO.getSurveyId());
            return false;
        }

        Optional<Dialogue> dialogueOptional = dialogueDAO.getActiveDialogue(user.getId());
        if (dialogueOptional.isPresent()) {
            logger.error("User {} has active dialogue {}, please finish it first.", user.getId(), dialogueOptional.get().getId());
            return false;
        }
        else {
            Dialogue dialogue = new Dialogue();
            dialogue.setUser(user);
            dialogue.setFinished(false);
            dialogue.setConfirmed(false);
            dialogue.setSurvey(survey);
            dialogue.setLastQuestion(0);
            dialogue.setProvider(surveyDTO.getProvider().name());
            final Dialogue savedDialogue = dialogueRepository.save(dialogue);
            Cache.SESSION.put(user.getFacebookId(), dialogue.getId());
            executors.submit(() -> dialogueService.startDialogue(savedDialogue));

            logger.info("User {} has successfully started conversation with bot. Dialogue id {}", user.getId(), dialogue.getId());
            return true;
        }
    }
}
