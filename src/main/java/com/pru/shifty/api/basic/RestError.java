package com.pru.shifty.api.basic;


public class RestError {
    private String message;

    public RestError() {}

    public RestError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
