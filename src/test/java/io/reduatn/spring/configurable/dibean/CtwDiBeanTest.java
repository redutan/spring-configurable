package io.reduatn.spring.configurable.dibean;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * {@code @Configurable} 컴파일 타임 위빙 테스트
 * <p>
 * 컴파일 타임 시 위빙을 걸려면 ajc 컴파일러를 사용하면 된다.
 * </p>
 *
 * @author myeongju.jung
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@EnableSpringConfigured
public class CtwDiBeanTest {
    @Test
    public void newDiPojo() throws Exception {
        // given
        // when
        DiBean bean = new DiBean();
        // then
        assertThat(bean.getPojoRepository(), is(notNullValue()));
    }

    @Test
    public void newDiPojo_checkEquals() throws Exception {
        // given
        DiBean bean1 = new DiBean();
        DiBean bean2 = new DiBean();
        // when
        boolean result = bean1.equals(bean2);
        // then
        assertThat(result, is(true));
    }

    @Test
    public void newDiPojo_checkSame() throws Exception {
        // given
        DiBean bean1 = new DiBean();
        DiBean bean2 = new DiBean();
        // when
        boolean result = bean1 == bean2;
        // then
        assertThat(result, is(false));
    }
}
