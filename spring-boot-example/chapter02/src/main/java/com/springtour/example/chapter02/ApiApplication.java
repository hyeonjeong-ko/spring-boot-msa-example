package com.springtour.example.chapter02;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Arrays;

@Slf4j
@SpringBootApplication
public class ApiApplication {

    public static void main(String[] args) {

        // 스프링 빈 컨테이너 객체 리턴
        ConfigurableApplicationContext ctx = SpringApplication.run(Chapter02Application.class, args);

        // 인자에 맞는 스프링 빈 객체 리턴
        Environment env = ctx.getBean(Environment.class);

        // port value 값을 변수에 저장
        String portValue = env.getProperty("server.port");
        log.info("Customized Port : {}", portValue);

        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.stream(beanNames).forEach(name -> log.info("Bean Name : {}", name));
    }
}
