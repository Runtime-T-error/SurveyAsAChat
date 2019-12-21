package com.runtimeterror.saac.service;

import com.runtimeterror.saac.Configuration;
import com.runtimeterror.saac.dto.MessagingException;
import com.runtimeterror.saac.dto.SurveyItemMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service("FacebookMessaging")
public class FacebookMessagingService implements MessagingService {

    private static final Logger logger = LoggerFactory.getLogger(FacebookMessagingService.class);

    @Override
    public boolean sendMessage(SurveyItemMessage item) {
        logger.info("Sending message to facebook "+item);
//        WebClient.create(Configuration.facebookMessagingServiceUrl())
//                .post()
//                .uri("message")
//                .body(BodyInserters.fromValue(item))
//                .retrieve()
//                .onRawStatus(status -> status >= 400, resp -> Mono.just(new MessagingException("Message failed")))
//                .bodyToMono(Void.class)
//                .block(Configuration.facebookMessagingServiceTimeout());
        return true;
    }
}
