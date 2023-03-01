package com.spring.model.request;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
public class OrderRequest {

    @NotBlank(message = "상품명를 입력해주세요.")
    private String menu;
    @NotNull(message = "상품 가격을 입력해주세요.")
    private Long price;

    public OrderRequest(String menu, Long price) {
        this.menu = menu;
        this.price = price;
    }
}
