package com.runtimeterror.saac.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.runtimeterror.saac.dto.SurveyItemMessage;
import com.runtimeterror.saac.service.provider.Provider;
import com.runtimeterror.saac.service.provider.ProviderResolver;
import com.runtimeterror.saac.service.provider.ResolvingException;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class MessagingService {

    private static final Logger logger = LoggerFactory.getLogger(MessagingService.class);
    public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");
    private static final ObjectMapper mapper = new ObjectMapper();


    public boolean sendMessage(SurveyItemMessage item, Provider provider) {
        logger.info("Sending message to facebook "+item);

        try {
            String providerUrl = ProviderResolver.resolve(provider);

            OkHttpClient client = new OkHttpClient.Builder()
                    .connectionSpecs(Arrays.asList(ConnectionSpec.MODERN_TLS, ConnectionSpec.COMPATIBLE_TLS))
                    .build();


            try {
                RequestBody body = RequestBody.create(JSON, mapper.writeValueAsString(item));
                Request request = new Request.Builder()
                        .url(providerUrl)
                        .post(body)
                        .build();

                try (Response response = client.newCall(request).execute()) {
                    logger.info(response.toString());
                }
            } catch (Exception e) {
                logger.error("", e);
            }
        } catch (ResolvingException e) {
            logger.error("",e);
            return false;
        }

        return true;
    }
}
