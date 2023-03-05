package com.springPractice.webScope;

import com.springPractice.SpringPracticeApplication;
import com.springPractice.common.object.scope.City;
import org.springframework.context.annotation.*;
import org.springframework.web.context.WebApplicationContext;

@Configuration
@ComponentScan(basePackageClasses = SpringPracticeApplication.class)
public class WebAppConfig {
    @Bean
    //@RequestScope <- can be replaced
    @Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
    public City requestScopedBean() {
        return new City();
    }

    @Bean
//    @SessionScope
    @Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
    public City sessionScopedBean() {
        return new City();
    }

}