package io.reduatn.spring.configurable.dibean;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * @author myeongju.jung
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Import(CtwConfiguration.class)
public class DiBeanCtwTest {
    @Test
    public void newDiPojo() throws Exception {
        // given
        // when
        DiBean diPojo = new DiBean();
        // then
        assertThat(diPojo.getPojoRepository(), is(notNullValue()));
    }

    @Test
    public void newDiPojo_checkEquals() throws Exception {
        // given
        DiBean diPojo1 = new DiBean();
        DiBean diPojo2 = new DiBean();
        // when
        boolean result = diPojo1.equals(diPojo2);
        // then
        assertThat(result, is(true));
    }

    @Test
    public void newDiPojo_checkSame() throws Exception {
        // given
        DiBean diPojo1 = new DiBean();
        DiBean diPojo2 = new DiBean();
        // when
        boolean result = diPojo1 == diPojo2;
        // then
        assertThat(result, is(false));
    }
}
