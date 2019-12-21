package com.runtimeterror.saac.service;

import com.runtimeterror.saac.Configuration;
import com.runtimeterror.saac.dto.MessagingException;
import com.runtimeterror.saac.dto.SurveyItemMessage;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service("FacebookMessaging")
public class FacebookMessagingService implements MessagingService {

    @Override
    public void sendMessage(SurveyItemMessage item) {
        WebClient.create(Configuration.facebookMessagingServiceUrl())
                .post()
                .uri("message")
                .body(BodyInserters.fromValue(item))
                .retrieve()
                .onRawStatus(status -> status >= 400, resp -> Mono.just(new MessagingException("Message failed")))
                .bodyToMono(Void.class)
                .block(Configuration.facebookMessagingServiceTimeout());
    }
}
