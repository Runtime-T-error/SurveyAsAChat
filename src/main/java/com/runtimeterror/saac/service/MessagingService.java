package com.runtimeterror.saac.service;

import com.runtimeterror.saac.Configuration;
import com.runtimeterror.saac.dto.MessagingException;
import com.runtimeterror.saac.dto.SurveyItemMessage;
import com.runtimeterror.saac.service.provider.Provider;
import com.runtimeterror.saac.service.provider.ProviderResolver;
import com.runtimeterror.saac.service.provider.ResolvingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class MessagingService {

    private static final Logger logger = LoggerFactory.getLogger(MessagingService.class);

    public boolean sendMessage(SurveyItemMessage item, Provider provider) {
        logger.info("Sending message to facebook "+item);

        try {
            String providerUrl = ProviderResolver.resolve(provider);
//            WebClient.create(providerUrl)
//                    .post()
//                    .uri("message")
//                    .body(BodyInserters.fromValue(item))
//                    .retrieve()
//                    .onRawStatus(status -> status >= 400, resp -> Mono.just(new MessagingException("Message failed")))
//                    .bodyToMono(Void.class)
//                    .block(Configuration.facebookMessagingServiceTimeout());
        } catch (ResolvingException e) {
            logger.error("",e);
            return false;
        }

        return true;
    }
}
