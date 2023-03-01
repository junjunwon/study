package com.spring.model.response.error;


import lombok.Getter;

@Getter
public class ErrorResponse {
    private boolean isSuccess;
    private String errorMessage;

    public ErrorResponse(boolean isSuccess, String errorMessage) {
        this.isSuccess = isSuccess;
        this.errorMessage = errorMessage;
    }
}
