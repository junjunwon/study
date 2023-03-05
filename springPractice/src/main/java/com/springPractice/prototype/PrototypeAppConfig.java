package com.springPractice.prototype;

import com.springPractice.SpringPracticeApplication;
import com.springPractice.common.object.scope.City;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackageClasses = SpringPracticeApplication.class)
public class PrototypeAppConfig {
    /**
     * 프로토타입
     * 스프링 컨테이너로부터 항상 다른 인스턴스를 반환한다.
     * 스프링 컨테이너에서 빈을 조회할 때 생성되고 초기화 메서드도 실행된다.
     * 스프링 컨테이너는 프로토타입 빈을 생성하고, 의존관계 주입, 초기화까지만 처리
     *  -> 즉, 클라이언트에게 빈을 반환한 이후에는 생성된 프로토타입 빈을 관리하지 않는다.
     *  즉, 빈을 관리할 책임은 클라이언트에 있으므로 @PreDestory 종료 콜백 메서드가 호출되지 않는다.
     *
     */
    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public City cityPrototype() {

        return new City();
    }


}