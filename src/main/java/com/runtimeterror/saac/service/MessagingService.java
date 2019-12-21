package com.runtimeterror.saac.service;

import com.runtimeterror.saac.dto.SurveyItemMessage;


public interface MessagingService {
     boolean sendMessage(SurveyItemMessage item);
}
