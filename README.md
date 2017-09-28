# Spring @Configurable

스프링프레임워크 2.5 부터 지원된 Entity와 같은 도메인 모델에서 DI를 받기 위한 기술

특정 도메인 객체에 `@Configurable` 를 선언하고 도메인 내 필드에 `@Autowired`를 이용해 의존성을 주입시키면
Spring bean이 주입되는 설정이 가능함

*Production Code*

```java
@Data
@Configurable
public class Entity {
    @Autowired
    private EntityRepository repository;
    
    private Long entityNo;
    private String description;
}
``` 

*Test Code*

```java
@Test
public void newEntity() {
    Entity entity = new Entity();
    assertThat(entity.getRepository(), is(notNullValue()));
}
```

이런 것이 가능해진다

궁극적으로 스프링에서 DDD를 지원하기 위한 포석이었다.