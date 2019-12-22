package com.runtimeterror.saac.service.provider;

import java.util.Optional;

public class ProviderResolver {

    public static String resolve(Provider provider) throws ResolvingException {
        switch (provider) {
            case VIBER: case TELEGRAF: case WHATSAPP:
                throw new ResolvingException("Unable to resolve url for connection "+provider);
            case FACEBOOK:
                return Optional.ofNullable(System.getProperty("connector.facebook.url"))
                        .orElse(Optional.ofNullable(System.getenv("CONNECTOR_FACEBOOK"))
                        .orElse("http://localhost:8081/facebook"));
            default:
                throw new ResolvingException("Unknown provider");
        }
    }

}
