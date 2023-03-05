package com.springPractice.singleton;

import com.springPractice.common.object.scope.City;
import org.springframework.stereotype.Component;

@Component
public class CitySingletonService {

    private final SingletonAppConfig applicationContext;

    public CitySingletonService(SingletonAppConfig applicationContext) {
        this.applicationContext = applicationContext;
    }

    public boolean isSingletonObject() {
        City singletonA = applicationContext.citySingleton();
        City singletonB = applicationContext.citySingleton();

        singletonA.setName("광교중앙역");

        return singletonB.getName() == singletonA.getName() ? true : false;
    }
}
