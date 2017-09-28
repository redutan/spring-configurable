package io.reduatn.spring.configurable.pojo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * @author myeongju.jung
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@Import(BeanConfiguration.class)
public class PojoBeanFactoryTest {
    @Autowired
    private BeanFactory beanFactory;

    @Test
    public void newPojo() throws Exception {
        // given
        // when
        Pojo pojo = beanFactory.getBean("pojo", Pojo.class);
        // then
        assertThat(pojo.getPojoRepository(), is(notNullValue()));
    }

    @Test
    public void newPojo_checkEquals() throws Exception {
        // given
        Pojo pojo1 = beanFactory.getBean("pojo", Pojo.class);
        Pojo pojo2 = beanFactory.getBean("pojo", Pojo.class);
        // when
        boolean isEqual = pojo1.equals(pojo2);
        // then
        assertThat(isEqual, is(true));
    }

    @Test
    public void newPojo_checkSame() throws Exception {
        // given
        Pojo pojo1 = beanFactory.getBean("pojo", Pojo.class);
        Pojo pojo2 = beanFactory.getBean("pojo", Pojo.class);
        // when
        boolean isSame = pojo1 == pojo2;
        // then
        assertThat(isSame, is(true));
    }

    @Test
    public void newPrototypePojo() throws Exception {
        // given
        // when
        Pojo pojo = beanFactory.getBean("prototypePojo", Pojo.class);
        // then
        assertThat(pojo.getPojoRepository(), is(notNullValue()));
    }

    @Test
    public void newPrototypePojo_checkEquals() throws Exception {
        // given
        Pojo pojo1 = beanFactory.getBean("prototypePojo", Pojo.class);
        Pojo pojo2 = beanFactory.getBean("prototypePojo", Pojo.class);
        // when
        boolean isEqual = pojo1.equals(pojo2);
        // then
        assertThat(isEqual, is(true));
    }

    @Test
    public void newPrototypePojo_checkSame() throws Exception {
        // given
        Pojo pojo1 = beanFactory.getBean("prototypePojo", Pojo.class);
        Pojo pojo2 = beanFactory.getBean("prototypePojo", Pojo.class);
        // when
        boolean isSame = pojo1 == pojo2;
        // then
        assertThat(isSame, is(false));
    }
}

class BeanConfiguration {
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
