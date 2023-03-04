package com.springPractice.singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CityServiceTest {

    @Autowired
    CityService cityService;

    @Test
    void singletone() {
        Assertions.assertEquals(true, cityService.isSingletonObject());
    }

}