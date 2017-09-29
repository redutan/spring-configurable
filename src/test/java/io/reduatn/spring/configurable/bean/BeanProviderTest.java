package io.reduatn.spring.configurable.bean;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Provider;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * @author myeongju.jung
 */
@SuppressWarnings("SpringJavaAutowiringInspection")
@RunWith(SpringRunner.class)
@DataJpaTest
@Import(BeanConfiguration.class)
public class BeanProviderTest {

    @Autowired
    @Qualifier("bean")
    private Provider<Bean> pojoProvider;

    @Autowired
    @Qualifier("prototypeBean")
    private Provider<Bean> prototypePojoProvider;

    @Test
    public void newPojo() throws Exception {
        // given
        // when
        Bean bean = pojoProvider.get();
        // then
        assertThat(bean.getPojoRepository(), is(notNullValue()));
    }

    @Test
    public void newPojo_checkEquals() throws Exception {
        // given
        Bean bean1 = pojoProvider.get();
        Bean bean2 = pojoProvider.get();
        // when
        boolean isEqual = bean1.equals(bean2);
        // then
        assertThat(isEqual, is(true));
    }

    @Test
    public void newPojo_checkSame() throws Exception {
        // given
        Bean bean1 = pojoProvider.get();
        Bean bean2 = pojoProvider.get();
        // when
        boolean isSame = bean1 == bean2;
        // then
        assertThat(isSame, is(true));
    }

    @Test
    public void newPrototypePojo() throws Exception {
        // given
        // when
        Bean bean = prototypePojoProvider.get();
        // then
        assertThat(bean.getPojoRepository(), is(notNullValue()));
    }

    @Test
    public void newPrototypePojo_checkEquals() throws Exception {
        // given
        Bean bean1 = prototypePojoProvider.get();
        Bean bean2 = prototypePojoProvider.get();
        // when
        boolean isEqual = bean1.equals(bean2);
        // then
        assertThat(isEqual, is(true));
    }

    @Test
    public void newPrototypePojo_checkSame() throws Exception {
        // given
        Bean bean1 = prototypePojoProvider.get();
        Bean bean2 = prototypePojoProvider.get();
        // when
        boolean isSame = bean1 == bean2;
        // then
        assertThat(isSame, is(false));
    }
}

