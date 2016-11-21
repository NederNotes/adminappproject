package com.adminappproject.trajan.service.impl;

import com.adminappproject.trajan.service.PropertiesMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class PropertiesMessageServiceImpl implements PropertiesMessageService{

    @Autowired
    private MessageSource messageSource;

    @Override
    public String getMessage(String code) {
        return messageSource.getMessage(code, null, Locale.ENGLISH);
    }
}
