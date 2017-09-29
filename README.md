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

## 하지만

LTW, CTW를 적용하는 설정의 허들이 존재하기 때문에 적용이 쉽지 많은 않다.
또한 객체 디자인 적으로 객체 간 의존이 심해지고 대체할 수 있는 도메인 이벤트와 같은 방법이 제시 되면서 사장된 것 같다.
그래도 필요 시 사용하면 좋은 기술임에는 분명하다

개인적 경험 상 **커맨드 패턴**과 같은 곳에 적용하면 좋았다. 