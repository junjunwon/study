package com.spring;

import com.spring.config.ApplicationConfig;
import com.spring.service.order.OrderService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

@SpringBootTest
class ApplicationTests {

	@Test
	@DisplayName("ApplicationConfig 수동 빈 등록을 통한 빈주입. 정상적으로 테스트하려면 ApplicationConfig에 수동 주입 주석 해제 후 진행하기.")
	void contextLoadsByManual() {
		ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		String[] beanDefinitionNames = context.getBeanDefinitionNames();
		System.out.println(Arrays.toString(beanDefinitionNames));
		OrderService orderService = (OrderService) context.getBean("orderService");
	}

	@Test
	@DisplayName("componentScan을 통한 빈 등록")
	void contextLoadsByComponentScan() {
		ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		String[] beanDefinitions = context.getBeanDefinitionNames();

		String getExampleService = Arrays.stream(beanDefinitions).filter(beanDefinition -> beanDefinition.contains("exampleService")).toString();
		System.out.println(getExampleService);
	}

}
