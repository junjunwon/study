package com.spring.web.order;

import com.spring.exception.InvalidPriceException;
import com.spring.model.request.OrderRequest;
import com.spring.model.response.order.OrderResponse;
import com.spring.service.order.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/order")
    public OrderResponse save(@RequestBody @Valid OrderRequest orderRequest) {
        OrderResponse response = orderService.save(orderRequest);
        if (!response.isSuccess()) {
            throw new InvalidPriceException();
        }
        return response;
    }
}
