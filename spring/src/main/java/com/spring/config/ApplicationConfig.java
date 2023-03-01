package com.spring.config;

import com.spring.Application;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = Application.class)
public class ApplicationConfig {

    /**
     * 수동 주입의 경우 주석해제하고 테스트하기
     */
//    @Bean
//    public ExampleRepository exampleRepository() {
//        return new ExampleRepository() {};
//    }
//
//    @Bean
//    public ExampleController exampleController() {
//        return new ExampleController(exampleRepository());
//    }
//
//    @Bean
//    public ExampleService exampleService(ExampleRepository exampleRepository) {
//        ExampleService exampleService = new ExampleService();
//        exampleService.setExampleService(exampleRepository);
//        return exampleService;
//    }
}
