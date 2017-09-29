package io.reduatn.spring.configurable.bean;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

/**
 * @author myeongju.jung
 */
public class PojoTest {
    @Test
    public void newPojo() throws Exception {
        // given
        // when
        Bean pojo = new Bean();
        // then
        assertThat(pojo.getPojoRepository(), is(nullValue()));
    }
}