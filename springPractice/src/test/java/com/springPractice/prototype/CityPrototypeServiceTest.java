package com.springPractice.prototype;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CityPrototypeServiceTest {

    @Autowired
    private CityPrototypeService cityPrototypeService;

    @Test
    void testPrototypeInSingleton() {

        int requestSize = 3;
        int getResult = cityPrototypeService.getProtoTypeInSingleton(requestSize);

        Assertions.assertEquals(getResult, requestSize);
    }

    @Test
    void testPrototypeInSingletonByProvider() {

        int requestSize = 3;
        int getResult = cityPrototypeService.getProtoTypeInSingletonByProvider(requestSize);

        Assertions.assertEquals(getResult, requestSize);
    }
}