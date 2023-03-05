package com.springPractice.applicationScope;

import com.springPractice.SpringPracticeApplication;
import com.springPractice.common.object.scope.City;
import org.springframework.context.annotation.*;
import org.springframework.web.context.WebApplicationContext;

@Configuration
@ComponentScan(basePackageClasses = SpringPracticeApplication.class)
public class ApplicationScopeAppConfig {
    /**
     * 싱글톤과 비슷한 스코프
     * 같은 ServletContext의 여러 서블릿 베이스 어플리케이션에서 동일한 인스턴스 빈을 공유한다.
     * 반면 싱글톤은 하나의 application context에서만 동일한 인스턴스 빈을 공유한다.
     */
    @Bean
//    @ApplicationScope
    @Scope(
            value = WebApplicationContext.SCOPE_APPLICATION,
            proxyMode = ScopedProxyMode.TARGET_CLASS
    )
    public City applicationScopedBean() {
        return new City();
    }
}
