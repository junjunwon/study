package com.springPractice.singleton;

import org.springframework.stereotype.Component;

@Component
public class CityService {

    private final ApplicationConfig applicationContext;

    public CityService(ApplicationConfig applicationContext) {
        this.applicationContext = applicationContext;
    }

    public boolean isSingletonObject() {
        City singletonA = applicationContext.citySingleton();
        City singletonB = applicationContext.citySingleton();

        singletonA.setName("광교중앙역");

        return singletonB.getName() == singletonA.getName() ? true : false;
    }
}
