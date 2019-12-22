package com.runtimeterror.saac.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Cache {
    public static final Map<String, Long> SESSION = new ConcurrentHashMap<>();
}
