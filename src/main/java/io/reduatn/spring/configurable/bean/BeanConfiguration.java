package io.reduatn.spring.configurable.bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author myeongju.jung
 */
@Configuration
public class BeanConfiguration {
    @org.springframework.context.annotation.Bean
    Bean bean() {
        return new Bean();
    }

    @org.springframework.context.annotation.Bean
    @Scope("prototype")
    Bean prototypeBean() {
        return new Bean();
    }
}
