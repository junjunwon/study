package com.spring;

import com.spring.web.ExampleController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class ExampleControllerTest {

    @Autowired
    ApplicationContext applicationContext;

    @Test
    public void getBean() {
        //when
        ExampleController bean = applicationContext.getBean(ExampleController.class);
        //then
        assertNotNull(bean);
    }


}