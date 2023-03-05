package com.springPractice.prototype;

import org.springframework.stereotype.Component;

@Component
public class CityPrototypeService {

    private final PrototypeAppConfig applicationContext;

    private final ProtoTypeInSingleton protoTypeInSingleton;

    public CityPrototypeService(PrototypeAppConfig applicationContext, ProtoTypeInSingleton protoTypeInSingleton) {
        this.applicationContext = applicationContext;
        this.protoTypeInSingleton = protoTypeInSingleton;
    }

    public int getProtoTypeInSingleton (int size) {

        int result = 0;

        for (int i = 0; i < size; i++) {
            result += protoTypeInSingleton.injectNewPrototype();
        }

        return result;
    }

    public int getProtoTypeInSingletonByProvider (int size) {

        int result = 0;

        for (int i = 0; i < size; i++) {
            result += protoTypeInSingleton.injectNewPrototypeByProvider();
        }

        return result;
    }
}
