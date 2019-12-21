package com.runtimeterror.saac.service;

import com.runtimeterror.saac.model.bot.Dialogue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class DialogueService {

    private static final Logger logger = LoggerFactory.getLogger(DialogueService.class);

    @Async
    public void startSurvey(Dialogue dialogue) {
        logger.info("Starter dialogue {}", dialogue.getId());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("Finished dialogue {}", dialogue.getId());

    }


}
