package com.runtimeterror.saac.model;

import com.runtimeterror.saac.dto.ReceiverDTO;
import com.runtimeterror.saac.dto.SurveyItemMessage;
import com.runtimeterror.saac.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Service
public class Sequences {
    @Autowired
    private QuestionRepository questions;

    private static Map<UUID, Sequence> sequences = new ConcurrentHashMap<>();

    public Sequence createSequence(List<SurveyItemMessage> items, long userId) {
        UUID id = UUID.randomUUID();
        while(sequences.putIfAbsent(id, new Sequence(id, items)) != null) {
            id = UUID.randomUUID();
        }
        Sequence seq = sequences.get(id);
        for(SurveyItemMessage item : seq.getItems()) {
            item.setSequenceId(id);
            item.setReceiver(new ReceiverDTO(userId));
        }
        return seq;
    }

    public Sequence createRandomSequence(int length, long userId) {
        List<SurveyItemMessage> messages = new ArrayList<>();
        for(int i=0; i<length; i++) {
            long id = (int) (Math.random() * 128) + 3575;
            Question question = questions.findById(id).get();
            SurveyItemMessage item = new SurveyItemMessage();
            item.setQuestion(question.getName());
            item.setResponses(question.getAnswers().stream().map(Answer::getOptionText).collect(Collectors.toList()));
            messages.add(item);
        }
        return createSequence(messages, userId);
    }

    public Sequence getSequence(UUID id) {
        return sequences.get(id);
    }

    public Sequence removeSequence(UUID id) {
        return sequences.remove(id);
    }
}
