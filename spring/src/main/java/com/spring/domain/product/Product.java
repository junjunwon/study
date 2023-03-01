package com.spring.domain.product;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String menu;
    @Enumerated(EnumType.STRING)
    private ProductCategory category;
    private Long quantity;
    private Long price;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    public Product(String code, String menu, ProductCategory category, Long quantity,
                   Long price, LocalDateTime createdAt) {
        this.code = code;
        this.menu = menu;
        this.category = category;
        this.quantity = quantity;
        this.price = price;
        this.createdAt = createdAt;
    }

    //상품에서만 사용되는 카테고리 (마이너)
    @Getter
    public enum ProductCategory {

        KOREA("한식"),
        AMERICA("미국식");
        private final String name;

        ProductCategory(String name) {
            this.name = name;
        }
    }
}
