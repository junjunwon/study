package com.spring.model.response.order;

import com.spring.domain.order.Order;
import lombok.Getter;

@Getter
public class OrderResponse {
    private String menu;
    private Long orderTime;
    private boolean isSuccess;

    public OrderResponse(String menu, Long orderTime, boolean isSuccess) {
        this.menu = menu;
        this.orderTime = orderTime;
        this.isSuccess = isSuccess;
    }

    public static OrderResponse from(Order order) {
        return new OrderResponse(order.getMenu(), System.currentTimeMillis(), order.isSuccess());
    }
}
