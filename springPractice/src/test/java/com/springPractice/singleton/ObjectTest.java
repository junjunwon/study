package com.springPractice.singleton;

import com.springPractice.common.object.scope.City;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class ObjectTest {

    @Autowired
    SingletonAppConfig appConfig;

    @Test
    void singletonTest() {
        City citySingletonA = appConfig.citySingleton();
        City citySingletonB = appConfig.citySingleton();

        citySingletonA.setName("광교중앙역");

        Assertions.assertEquals(citySingletonA.getName(), citySingletonB.getName());
    }
}