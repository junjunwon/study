package com.springPractice.protoype;

import com.springPractice.common.object.scope.City;
import com.springPractice.prototype.PrototypeAppConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class PrototypeTest {

    @Autowired
    PrototypeAppConfig appConfig;

    @Test
    void prototypeTest() {
        String nameA = "광교";
        String nameB = "광교중앙";
        City cityPrototypeA = appConfig.cityPrototype();
        City cityPrototypeB = appConfig.cityPrototype();

        cityPrototypeA.setName(nameA);
        cityPrototypeB.setName(nameB);

        Assertions.assertNotEquals(cityPrototypeA.getName(), cityPrototypeB.getName());
        Assertions.assertEquals(cityPrototypeA.getName(), nameA);
        Assertions.assertEquals(cityPrototypeB.getName(), nameB);
    }


}