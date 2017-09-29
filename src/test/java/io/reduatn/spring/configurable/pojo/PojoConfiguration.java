package io.reduatn.spring.configurable.pojo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

/**
 * @author myeongju.jung
 */
class PojoConfiguration {
    @Bean
    Pojo pojo() {
        return new Pojo();
    }

    @Scope("prototype")
    @Bean
    Pojo prototypePojo() {
        return new Pojo();
    }
}
