package com.sjm.util;

public class AuthenticationException extends RuntimeException {

    public AuthenticationException(){
        super();
    }

    public AuthenticationException(String s){
        super(s);
    }
}
