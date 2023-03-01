package com.spring.service.order;

import com.spring.domain.order.Order;
import com.spring.domain.product.Product;
import com.spring.exception.DataNotFoundException;
import com.spring.model.request.OrderRequest;
import com.spring.model.response.order.OrderResponse;
import com.spring.repository.order.OrderRepository;
import com.spring.repository.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    @Transactional
    public OrderResponse save(OrderRequest orderRequest) {
        //상품 조회 검증
        Optional<Product> optionalProduct = productRepository.findByMenu(orderRequest.getMenu());
        if (!optionalProduct.isPresent()) {
            throw new DataNotFoundException();
        }
        Product product = optionalProduct.get();

        //금액 검증
        boolean success = orderRequest.getPrice().equals(product.getPrice()) ? true : false;

        Order order = Order.from(orderRequest, success);
        orderRepository.save(order);

        OrderResponse response = OrderResponse.from(order);
        return response;
    }
}
