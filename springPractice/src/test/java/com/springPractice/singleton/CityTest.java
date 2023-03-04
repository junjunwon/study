package com.springPractice.singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;


@SpringBootTest
class CityTest {

    @Autowired
    ApplicationContext applicationContext;

    @Test
    void singletonTest() {
        City citySingletonA = (City) applicationContext.getBean("citySingleton");
        City citySingletonB = (City) applicationContext.getBean("citySingleton");

        citySingletonA.setName("광교중앙역");

        Assertions.assertEquals(citySingletonA.getName(), citySingletonB.getName());

        ((AbstractApplicationContext) applicationContext).close();
    }

    @Test
    void prototypeTest() {
        String nameA = "광교";
        String nameB = "광교중앙";
        City cityPrototypeA = (City) applicationContext.getBean("cityPrototype");
        City cityPrototypeB = (City) applicationContext.getBean("cityPrototype");

        cityPrototypeA.setName(nameA);
        cityPrototypeB.setName(nameB);

        Assertions.assertNotEquals(cityPrototypeA.getName(), cityPrototypeB.getName());
        Assertions.assertEquals(cityPrototypeA.getName(), nameA);
        Assertions.assertEquals(cityPrototypeB.getName(), nameB);
    }


}