package io.reduatn.spring.configurable.pojo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 * @author myeongju.jung
 */
@SuppressWarnings({"SpringAutowiredFieldsWarningInspection", "SpringJavaAutowiredMembersInspection"})
@Entity
@Data
public class Pojo {
    @Transient
    @Autowired
    private PojoRepository pojoRepository;

    @Id
    @GeneratedValue
    private Long pojoNo;
    private String description;
}
