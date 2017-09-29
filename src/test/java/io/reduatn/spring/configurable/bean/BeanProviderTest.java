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
        Bean pojo = pojoProvider.get();
        // then
        assertThat(pojo.getPojoRepository(), is(notNullValue()));
    }

    @Test
    public void newPojo_checkEquals() throws Exception {
        // given
        Bean pojo1 = pojoProvider.get();
        Bean pojo2 = pojoProvider.get();
        // when
        boolean isEqual = pojo1.equals(pojo2);
        // then
        assertThat(isEqual, is(true));
    }

    @Test
    public void newPojo_checkSame() throws Exception {
        // given
        Bean pojo1 = pojoProvider.get();
        Bean pojo2 = pojoProvider.get();
        // when
        boolean isSame = pojo1 == pojo2;
        // then
        assertThat(isSame, is(true));
    }

    @Test
    public void newPrototypePojo() throws Exception {
        // given
        // when
        Bean pojo = prototypePojoProvider.get();
        // then
        assertThat(pojo.getPojoRepository(), is(notNullValue()));
    }

    @Test
    public void newPrototypePojo_checkEquals() throws Exception {
        // given
        Bean pojo1 = prototypePojoProvider.get();
        Bean pojo2 = prototypePojoProvider.get();
        // when
        boolean isEqual = pojo1.equals(pojo2);
        // then
        assertThat(isEqual, is(true));
    }

    @Test
    public void newPrototypePojo_checkSame() throws Exception {
        // given
        Bean pojo1 = prototypePojoProvider.get();
        Bean pojo2 = prototypePojoProvider.get();
        // when
        boolean isSame = pojo1 == pojo2;
        // then
        assertThat(isSame, is(false));
    }
}

