package com.springPractice.prototype;

import org.springframework.stereotype.Component;

@Component
public class CityPrototypeService {

    private final PrototypeAppConfig applicationContext;

    public CityPrototypeService(PrototypeAppConfig applicationContext) {
        this.applicationContext = applicationContext;
    }
}
