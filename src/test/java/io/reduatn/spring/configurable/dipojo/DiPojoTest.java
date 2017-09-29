package io.reduatn.spring.configurable.dipojo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * @author myeongju.jung
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DiPojoTest {
    @Test
    public void newDiPojo() throws Exception {
        // given
        // when
        DiPojo diPojo = new DiPojo();
        // then
        assertThat(diPojo.getPojoRepository(), is(notNullValue()));
    }

    @Test
    public void newDiPojo_checkEquals() throws Exception {
        // given
        DiPojo diPojo1 = new DiPojo();
        DiPojo diPojo2 = new DiPojo();
        // when
        boolean result = diPojo1.equals(diPojo2);
        // then
        assertThat(result, is(true));
    }

    @Test
    public void newDiPojo_checkSame() throws Exception {
        // given
        DiPojo diPojo1 = new DiPojo();
        DiPojo diPojo2 = new DiPojo();
        // when
        boolean result = diPojo1 == diPojo2;
        // then
        assertThat(result, is(false));
    }
}
