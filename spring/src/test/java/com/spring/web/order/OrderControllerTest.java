package com.spring.web.order;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.exception.InvalidPriceException;
import com.spring.model.request.OrderRequest;
import com.spring.repository.product.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class OrderControllerTest {

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    Validator validator;

    @BeforeEach
    void init() {

    }

    @DisplayName("주문 정상 등록 테스트")
    @Test
    void successOrder() throws Exception {
        //given
        String 요청_메뉴 = "CHICKEN";
        Long 요청_가격 = 20_000L;
        OrderRequest orderRequest = new OrderRequest(요청_메뉴, 요청_가격);
        String requestJson = objectMapper.writeValueAsString(orderRequest);

        mockMvc.perform(post("/api/order")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @DisplayName("금액 검증 실패 -> InvalidPriceException throw")
    @Test
    void exceptionInvalidPriceOrder() throws Exception {
        //given
        String 요청_메뉴 = "PIZZA";
        Long 요청_가격 = 12_000L;
        OrderRequest orderRequest = new OrderRequest(요청_메뉴, 요청_가격);

        String requestJson = objectMapper.writeValueAsString(orderRequest);

        mockMvc.perform(post("/api/order")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andExpect(result -> {
                    assertTrue(result.getResolvedException().getClass().
                            isAssignableFrom(InvalidPriceException.class));
                })
                .andReturn();
    }

    @DisplayName("Valid 실패 테스트")
    @Test
    void verifyValid() {
        //given
        String 요청_메뉴 = null;
        Long 요청_가격 = null;
        OrderRequest orderRequest = new OrderRequest(요청_메뉴, 요청_가격);
        //Valid
        String 메뉴_입력_검증 = "상품명를 입력해주세요.";
        String 가격_입력_검증 = "상품 가격을 입력해주세요.";

        Set<ConstraintViolation<OrderRequest>> violations = validator.validate(orderRequest);
        List<String> results = new ArrayList<>();
        violations.stream().forEach((violation) -> {
            results.add(violation.getMessage());
        });
        assertThat(violations).isNotEmpty();
        assertThat(results).contains(메뉴_입력_검증, 가격_입력_검증);
    }
}