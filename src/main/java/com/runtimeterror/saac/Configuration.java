package com.runtimeterror.saac;

import java.time.Duration;

public class Configuration {
    public static String facebookMessagingServiceUrl() {
        return "192.168.11.34:8080";
    }

    public static Duration facebookMessagingServiceTimeout() {
        return Duration.ofSeconds(10);
    }
}
