package io.reduatn.spring.configurable.pojo;

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
        Pojo pojo = new Pojo();
        // then
        assertThat(pojo.getPojoRepository(), is(nullValue()));
    }
}