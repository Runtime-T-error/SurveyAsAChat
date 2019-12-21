package com.runtimeterror.saac.service;

import com.runtimeterror.saac.dto.ReceiverDTO;
import com.runtimeterror.saac.dto.SurveyItemMessage;
import com.runtimeterror.saac.model.bot.Dialogue;
import com.runtimeterror.saac.model.bot.QuestionSurvey;
import com.runtimeterror.saac.model.def.AnswerOption;
import com.runtimeterror.saac.model.def.Question;
import com.runtimeterror.saac.repositories.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class DialogueService {

    private static final Logger logger = LoggerFactory.getLogger(DialogueService.class);

    private final FacebookMessagingService facebookMessagingService;
    private final AnswersRepository answersRepository;
    private final AnswersDAO answersDAO;
    private final SurveyRepository surveyRepository;
    private final QuestionSurveyRepository questionSurveyRepository;
    private final QuestionSurveyDAO questionSurveyDAO;
    private final AnswersOptionDAO answersOptionDAO;
    private final DialogueRepository dialogueRepository;

    public DialogueService(FacebookMessagingService facebookMessagingService,
                           AnswersRepository answersRepository,
                           AnswersDAO answersDAO, SurveyRepository surveyRepository,
                           QuestionSurveyRepository questionSurveyRepository,
                           QuestionSurveyDAO questionSurveyDAO,
                           AnswersOptionDAO answersOptionDAO,
                           DialogueRepository dialogueRepository) {

        this.facebookMessagingService = facebookMessagingService;
        this.answersRepository = answersRepository;
        this.answersDAO = answersDAO;
        this.surveyRepository = surveyRepository;
        this.questionSurveyRepository = questionSurveyRepository;
        this.questionSurveyDAO = questionSurveyDAO;
        this.answersOptionDAO = answersOptionDAO;
        this.dialogueRepository = dialogueRepository;
    }

    @Transactional
    public void startDialogue(Dialogue dialogue) {
        logger.info("Starter dialogue {}", dialogue.getId());
        try {
            sendNextQuestion(dialogue);
        } catch (Exception e) {
            logger.error("error: ",e);
        }
    }

    public boolean sendGreetings() {
        return true;
    }

    public boolean sendNextQuestion(Dialogue dialogue) {
//        List<Answer> answerList = answersDAO.getAllAnswersBySurveyId(user.getId(), survey.getId());

        Integer lastQuestion = dialogue.getLastQuestion();

        Optional<QuestionSurvey> questionSurvey = questionSurveyDAO.getNextQuestion(dialogue.getSurvey().getId(), lastQuestion);
        if (questionSurvey.isPresent()) {
            Question question = questionSurvey.get().getQuestion();
            ReceiverDTO receiverDTO = new ReceiverDTO();
            receiverDTO.setId(dialogue.getUser().getFacebookId());

            List<AnswerOption> options = answersOptionDAO.getOptionsForQuestion(question.getId());

            SurveyItemMessage surveyItemMessage = new SurveyItemMessage();
            surveyItemMessage.setReceiver(receiverDTO);
            surveyItemMessage.setQuestion(question.getQuestionText());
            surveyItemMessage.setResponses(options.stream().map(AnswerOption::getOptionText).collect(Collectors.toList()));

            if (facebookMessagingService.sendMessage(surveyItemMessage)) {
                dialogue.setLastQuestion(lastQuestion+1);
                dialogueRepository.save(dialogue);
                logger.info("Saved dialogue "+dialogue);
            }
            else {
                logger.error("Unable to send message!");
                return false;
            }
        }
        else {
            logger.info("Unable to find next question {}. Dialogue is finished. Submit results!", lastQuestion);
            dialogue.setFinished(true);
            dialogueRepository.save(dialogue);
        }
        return true;
    }

    public boolean sendFarewellMessage() {
        return true;
    }

}
