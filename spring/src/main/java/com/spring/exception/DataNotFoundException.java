package com.spring.exception;

import lombok.Getter;

@Getter
public class DataNotFoundException extends RootException {

    private static final String MESSAGE = "존재하지 않는 데이터입니다.";

    public DataNotFoundException() {
        super(MESSAGE);
    }
}
