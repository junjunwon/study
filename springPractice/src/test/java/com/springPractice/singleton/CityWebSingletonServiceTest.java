package com.springPractice.singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CityWebSingletonServiceTest {

    @Autowired
    CitySingletonService citySingletonService;

    @Test
    void singleton() {
        Assertions.assertEquals(true, citySingletonService.isSingletonObject());
    }

}