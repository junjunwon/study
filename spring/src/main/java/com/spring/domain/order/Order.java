package com.spring.domain.order;

import com.spring.model.request.OrderRequest;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Table(name = "orders") // Order-By 예약어로 인한 오류 방지
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long price;
    private String menu;
    private boolean success;
    private Long amount; //수량
    private String code; //마이너
    //- 배송지 : embedded → 주문서 배송지 (마이너)
    //- 고객정보 : embedded → 주문서 고객정보 (마이너)

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    public Order(Long price, String menu, boolean success) {
        this.price = price;
        this.menu = menu;
        this.success = success;
    }

    public static Order from(OrderRequest orderRequest, boolean success) {
        return new Order(orderRequest.getPrice(), orderRequest.getMenu(), success);
    }
}
