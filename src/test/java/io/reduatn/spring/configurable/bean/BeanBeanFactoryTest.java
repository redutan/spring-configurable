package io.reduatn.spring.configurable.bean;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
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
public class BeanBeanFactoryTest {
    @Autowired
    private BeanFactory beanFactory;

    @Test
    public void newPojo() throws Exception {
        // given
        // when
        Bean pojo = beanFactory.getBean("bean", Bean.class);
        // then
        assertThat(pojo.getPojoRepository(), is(notNullValue()));
    }

    @Test
    public void newPojo_checkEquals() throws Exception {
        // given
        Bean pojo1 = beanFactory.getBean("bean", Bean.class);
        Bean pojo2 = beanFactory.getBean("bean", Bean.class);
        // when
        boolean isEqual = pojo1.equals(pojo2);
        // then
        assertThat(isEqual, is(true));
    }

    @Test
    public void newPojo_checkSame() throws Exception {
        // given
        Bean pojo1 = beanFactory.getBean("bean", Bean.class);
        Bean pojo2 = beanFactory.getBean("bean", Bean.class);
        // when
        boolean isSame = pojo1 == pojo2;
        // then
        assertThat(isSame, is(true));
    }

    @Test
    public void newPrototypePojo() throws Exception {
        // given
        // when
        Bean pojo = beanFactory.getBean("prototypeBean", Bean.class);
        // then
        assertThat(pojo.getPojoRepository(), is(notNullValue()));
    }

    @Test
    public void newPrototypePojo_checkEquals() throws Exception {
        // given
        Bean pojo1 = beanFactory.getBean("prototypeBean", Bean.class);
        Bean pojo2 = beanFactory.getBean("prototypeBean", Bean.class);
        // when
        boolean isEqual = pojo1.equals(pojo2);
        // then
        assertThat(isEqual, is(true));
    }

    @Test
    public void newPrototypePojo_checkSame() throws Exception {
        // given
        Bean pojo1 = beanFactory.getBean("prototypeBean", Bean.class);
        Bean pojo2 = beanFactory.getBean("prototypeBean", Bean.class);
        // when
        boolean isSame = pojo1 == pojo2;
        // then
        assertThat(isSame, is(false));
    }
}

