package com.sjm.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.sjm.util.AuthenticationException;
import com.sjm.util.Message;

/**
 * controller增强
 */
@RestControllerAdvice
public class Advice {

    @ExceptionHandler(value=AuthenticationException.class)
    public Message unknownAccountHandler(AuthenticationException exception) {
        return Message.fail().add("info" , exception.getMessage());
    }
}
