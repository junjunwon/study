package com.spring.exception;

import lombok.Getter;

@Getter
public class InvalidPriceException extends RootException {
    private static final String MESSAGE = "주문한 상품의 금액이 일치하지 않습니다.";

    public InvalidPriceException() {
        super(MESSAGE);
    }
}
