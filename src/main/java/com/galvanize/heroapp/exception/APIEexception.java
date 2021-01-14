package com.galvanize.heroapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class APIEexception extends RuntimeException {

    private String erroMsg;

    public APIEexception(String erroMsg){
        this.erroMsg = erroMsg;
    }

    public String getErroMsg() {
        return erroMsg;
    }

    @Override
    public String toString() {
        return "APIEexception{" +
                "erroMsg='" + erroMsg + '\'' +
                '}';
    }
}
