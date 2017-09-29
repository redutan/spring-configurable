package io.reduatn.spring.configurable.dibean;

import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;

/**
 * 로드 타임 위빙 설정
 * <p>
 * {@code @EnableLoadTimeWeaving} 어노테이션을 추가하고
 * {@code --javaagent:실제파일경로/spring-instrument-4.3.11.RELEASE.jar} 옵션을 설정해야 한다.
 * </p>
 *
 * @author myeongju.jung
 */
@EnableSpringConfigured
@EnableLoadTimeWeaving
public class LtwConfiguration {
    //-javaagent:/Users/myeongju.jung/.gradle/caches/modules-2/files-2.1/org.springframework/spring-instrument/4.3.11.RELEASE/6270450e60ae197a1fc24b144b07813d37896245/spring-instrument-4.3.11.RELEASE.jar
}
