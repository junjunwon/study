package com.springPractice.prototype;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class ProtoTypeInSingleton {

    private final ApplicationContext applicationContext;

    private final ObjectProvider<ProtoType> protoTypeObjectProvider;

    public ProtoTypeInSingleton(ApplicationContext applicationContext, ObjectProvider<ProtoType> protoTypeObjectProvider) {
        this.applicationContext = applicationContext;
        this.protoTypeObjectProvider = protoTypeObjectProvider;
    }

    public int injectNewPrototype() {
        /**
         * 새로운 프로토타입 빈 생성 <-applicationcontext에서 직접 주입
         * 즉, 직접 필요한 의존성을 찾아서 주입하는 방식 -> Dependency Lookup (DL)
         */
        ProtoType protoType = applicationContext.getBean(ProtoType.class);

        protoType.addCount();

        return protoType.getCount();
    }

    public int injectNewPrototypeByProvider() {
        /**
         * ApplicationContext에서 직접 주입받을 경우 스프링 컨테이너에 종속적인 코드가 되고, 단위 테스트도 어려워진다.
         * 그래서 스프링 컨텍스트 전체를 주입받지 말고 ObjectProvider를 주입받는다. -> 지정한 빈을 컨테이너에서 대신 찾아주는 DL 서비스
         * ObjectProvider의 getObject()를 호출하면 내부에서는 스프링 컨테이너를 통해 해당 빈을 찾아서 반환한다.(DL)
         */
        ProtoType protoType = protoTypeObjectProvider.getObject();

        protoType.addCount();

        return protoType.getCount();
    }

    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    @Component
    public class ProtoType implements InitializingBean, DisposableBean {
        private int count = 0;

        public void addCount() {
            count++;
        }

        public int getCount() {
            return count;
        }

        @Override
        public void afterPropertiesSet() throws Exception {
            System.out.println("initialized and injected by spring container");
        }

        @Override
        public void destroy() throws Exception {
            System.out.println("will be destroyed by spring container");
        }
    }
}
