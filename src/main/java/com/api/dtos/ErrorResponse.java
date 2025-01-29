package com.api.dtos;

public class ErrorResponse {

    private String message;
    private String timestamp;

    public ErrorResponse(String message, String timestamp) {
        this.message = message;
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getTimestamp() {
        return timestamp;
    }
}
