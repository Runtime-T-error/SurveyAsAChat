package com.runtimeterror.saac.service;

import com.runtimeterror.saac.dto.ReceiverDTO;
import com.runtimeterror.saac.dto.SurveyItemMessage;
import com.runtimeterror.saac.model.bot.Answer;
import com.runtimeterror.saac.model.bot.Dialogue;
import com.runtimeterror.saac.model.bot.QuestionSurvey;
import com.runtimeterror.saac.model.def.AnswerOption;
import com.runtimeterror.saac.model.def.Question;
import com.runtimeterror.saac.repositories.*;
import com.runtimeterror.saac.service.provider.Provider;
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

    private final MessagingService messagingService;
    private final AnswerOptionRepository answerOptionRepository;
    private final AnswersDAO answersDAO;
    private final AnswersRepository answersRepository;
    private final QuestionSurveyRepository questionSurveyRepository;
    private final QuestionSurveyDAO questionSurveyDAO;
    private final AnswersOptionDAO answersOptionDAO;
    private final DialogueRepository dialogueRepository;

    public DialogueService(MessagingService messagingService,
                           AnswerOptionRepository answerOptionRepository,
                           AnswersDAO answersDAO,
                           AnswersRepository answersRepository,
                           QuestionSurveyRepository questionSurveyRepository,
                           QuestionSurveyDAO questionSurveyDAO,
                           AnswersOptionDAO answersOptionDAO,
                           DialogueRepository dialogueRepository) {

        this.messagingService = messagingService;
        this.answerOptionRepository = answerOptionRepository;
        this.answersDAO = answersDAO;
        this.answersRepository = answersRepository;
        this.questionSurveyRepository = questionSurveyRepository;
        this.questionSurveyDAO = questionSurveyDAO;
        this.answersOptionDAO = answersOptionDAO;
        this.dialogueRepository = dialogueRepository;
    }

    @Transactional
    public void startDialogue(Dialogue dialogue) {
        logger.info("Starting dialogue {}", dialogue.getId());
        try {
            sendGreetings(dialogue);
        } catch (Exception e) {
            logger.error("error: ",e);
        }
    }

    private boolean sendGreetings(Dialogue dialogue) {
        logger.info("Sending greetings to user {}", dialogue.getUser().getEmail());
        return true;
    }

    @Transactional
    public boolean handleSurveyResponse(List<String> response, Long dialogueId) {
        Optional<Dialogue> dialogueOptional = dialogueRepository.findById(dialogueId);
        if (dialogueOptional.isPresent()) {
            Dialogue dialogue = dialogueOptional.get();
            if (dialogue.getFinished()) {
                logger.error("Response ({}) cannot be sent to dialogue {} because it is finished.", response, dialogueId);
                return false;
            }
            if (dialogue.getConfirmed()) {
                if (submitResponse(response, dialogue)) {
                    return sendNextQuestion(dialogue);
                } else {
                    logger.error("Unable to submit response: {}, for dialogue {}", response, dialogue);
                    return false;
                }
            }
            else {
                if (!response.isEmpty()){
                    if ("yes".equalsIgnoreCase(response.get(0))) {
                        dialogue.setConfirmed(true);
                        dialogueRepository.save(dialogue);
                        logger.info("User {} confirmed survey {}. Proceed with questions...", dialogue.getUser().getEmail(), dialogue.getSurvey().getId());
                        return sendNextQuestion(dialogue);
                    }
                    else if ("no".equalsIgnoreCase(response.get(0))) {
                        dialogue.setFinished(true);
                        dialogueRepository.save(dialogue);
                        logger.info("User {} answered with NO answer to survey ({}) confirmation. Stopping dialogue.", dialogue.getUser().getEmail(), dialogue.getSurvey().getId());
                    }
                    else {
                        logger.info("User {} answered with unknown answer {}. Sending greeting message again...", dialogue.getUser().getEmail(), response.get(0));
                        return sendGreetings(dialogue);
                    }
                }
                else {
                    return sendGreetings(dialogue);
                }
            }
        }
        else {
            logger.error("Dialogue with id {} does not exist.", dialogueId);
        }
        return false;
    }

    public boolean submitResponse(List<String> response, Dialogue dialogue) {
        try {
            Optional<Question> question = getLastQuestionFromDialogue(dialogue);

            if (question.isEmpty()) {
                return true;
            }

            Answer answer = new Answer();
            answer.setSurvey(dialogue.getSurvey());
            answer.setWithUser(dialogue.getUser());

            answer.setAnswers(String.join("#####", response));

            answersRepository.save(answer);
            return true;
        }
        catch (Exception e) {
            logger.error("", e);
            return false;
        }
    }

    private Optional<Question> getLastQuestionFromDialogue(Dialogue dialogue) {
        Integer lastQuestion = dialogue.getLastQuestion();
        Optional<QuestionSurvey> questionSurvey = questionSurveyDAO.getNextQuestion(dialogue.getSurvey().getId(), lastQuestion);
        return questionSurvey.map(QuestionSurvey::getQuestion);
    }

    private boolean sendNextQuestion(Dialogue dialogue) {
//        List<Answer> answerList = answersDAO.getAllAnswersBySurveyId(user.getId(), survey.getId());

        Optional<Question> questionOptional = getLastQuestionFromDialogue(dialogue);
        if (questionOptional.isPresent()) {
            Question question = questionOptional.get();
            ReceiverDTO receiverDTO = new ReceiverDTO();
            receiverDTO.setId(dialogue.getUser().getFacebookId());

            List<AnswerOption> options = answersOptionDAO.getOptionsForQuestion(question.getId());

            SurveyItemMessage surveyItemMessage = new SurveyItemMessage();
            surveyItemMessage.setReceiver(receiverDTO);
            surveyItemMessage.setQuestion(question.getQuestionText());
            surveyItemMessage.setResponses(options.stream().map(AnswerOption::getOptionText).collect(Collectors.toList()));

            if (messagingService.sendMessage(surveyItemMessage, Provider.valueOf(dialogue.getProvider()))) {
                dialogue.setLastQuestion(dialogue.getLastQuestion() + 1);
                dialogueRepository.save(dialogue);
                logger.info("Saved dialogue "+dialogue);
            }
            else {
                logger.error("Unable to send message!");
                return false;
            }
        }
        else {
            logger.info("Unable to find next question {}. Dialogue is finished. Submiting results!", dialogue.getLastQuestion());
            submitResults(dialogue);
        }
        return true;
    }

    public void submitResults(Dialogue dialogue) {
        //TODO
        try {
            dialogue.setFinished(true);
            dialogueRepository.save(dialogue);

            if (!sendFarewellMessage(dialogue)) {
                logger.error("Error while sending farewell message to user {}", dialogue.getUser().getEmail());
            }
        }
        catch (Exception e) {
            logger.error("Unable to submit results", e);
        }
    }

    public boolean sendFarewellMessage(Dialogue dialogue) {
        logger.info("Sending farewell message to user {}", dialogue.getUser().getEmail());
        return true;
    }


}
