package com.springPractice.singleton;

import com.springPractice.SpringPracticeApplication;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackageClasses = SpringPracticeApplication.class)
public class ApplicationConfig {

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public City citySingleton() {
        /**
         * 싱글톤 : 항상 동일한 인스턴스를 return한다.
         */
        return new City();
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public City cityPrototype() {
        /**
         * 프로토타입 : 스프링 컨테이너로부터 항상 다른 인스턴스를 반환한다.
         */
        return new City();
    }


}