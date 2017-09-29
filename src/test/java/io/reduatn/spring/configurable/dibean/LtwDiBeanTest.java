package io.reduatn.spring.configurable.dibean;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * {@code @Configurable} 로드 타임 위빙 테스트
 * <p>
 * {@code @EnableLoadTimeWeaving} 어노테이션을 추가하고
 * {@code -javaagent:실제파일경로/spring-instrument-4.3.11.RELEASE.jar} 옵션을 설정해야 한다.
 * </p>
 *
 * @author myeongju.jung
 */
// -javaagent:/Users/myeongju.jung/.gradle/caches/modules-2/files-2.1/org.springframework/spring-instrument/4.3.11.RELEASE/6270450e60ae197a1fc24b144b07813d37896245/spring-instrument-4.3.11.RELEASE.jar
@RunWith(SpringRunner.class)
@SpringBootTest
@EnableSpringConfigured
@EnableLoadTimeWeaving
public class LtwDiBeanTest {
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
