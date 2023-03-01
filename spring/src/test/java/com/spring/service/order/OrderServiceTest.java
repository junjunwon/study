package com.spring.service.order;

import com.spring.domain.product.Product;
import com.spring.exception.DataNotFoundException;
import com.spring.exception.RootException;
import com.spring.model.request.OrderRequest;
import com.spring.model.response.order.OrderResponse;
import com.spring.repository.order.OrderRepository;
import com.spring.repository.product.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @InjectMocks
    OrderService orderService;

    @Mock
    OrderRepository orderRepository;

    @Mock
    ProductRepository productRepository;

    Product product;

    @BeforeEach
    void init() {
        String 주문_코드 = "PRODUCT-TEST-01";
        String 메뉴 = "PIZZA";
        Product.ProductCategory 카테고리 = Product.ProductCategory.AMERICA;
        Long 수량 = 10L;
        Long 가격 = 20_000L;
        LocalDateTime 등록일자 = LocalDateTime.now();
        //상품 등록
        product = new Product(주문_코드, 메뉴, 카테고리, 수량, 가격, 등록일자);

    }

    @DisplayName("금액 검증 -> 주문 정상 등록 테스트")
    @Test
    void successOrder() {
        //given
        String 요청_메뉴 = "PIZZA";
        Long 요청_가격 = 20_000L;
        OrderRequest orderRequest = new OrderRequest(요청_메뉴, 요청_가격);

        //when
        when(productRepository.findByMenu(orderRequest.getMenu())).thenReturn(Optional.ofNullable(product));
        OrderResponse orderResponse = orderService.save(orderRequest);

        //then
        Assertions.assertEquals(true, orderResponse.isSuccess());

    }

    @DisplayName("금액 검증 -> 주문 실패 등록 테스트")
    @Test
    void failOrder() {
        //given
        String 요청_메뉴 = "PIZZA";
        Long 요청_가격 = 12_000L;
        OrderRequest orderRequest = new OrderRequest(요청_메뉴, 요청_가격);

        //when
        when(productRepository.findByMenu(orderRequest.getMenu())).thenReturn(Optional.ofNullable(product));
        OrderResponse orderResponse = orderService.save(orderRequest);

        //then
        Assertions.assertEquals(false, orderResponse.isSuccess());

    }

    @DisplayName("상품이 없을 경우 DataNotFoundException throw")
    @Test
    void existNonProductForOrder() {
        //given
        String 요청_메뉴 = "PIZZA";
        Long 요청_가격 = 12_000L;
        String ERROR_MESSAGE = "존재하지 않는 데이터입니다.";
        OrderRequest orderRequest = new OrderRequest(요청_메뉴, 요청_가격);

        //when
        when(productRepository.findByMenu(orderRequest.getMenu())).thenReturn(Optional.ofNullable(null));

        //then
        RootException exception = Assertions.assertThrows(DataNotFoundException.class, () -> {
            orderService.save(orderRequest);
        });
        Assertions.assertEquals(ERROR_MESSAGE, exception.getDetailMessage());

    }

}