package io.reduatn.spring.configurable;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;

@SpringBootApplication
@EnableSpringConfigured
@EnableLoadTimeWeaving
public class SpringConfigurableApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringConfigurableApplication.class, args);
    }
}
