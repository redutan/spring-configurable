package io.reduatn.spring.configurable.bean;

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
public class Bean {
    @Transient
    @Autowired
    private BeanRepository pojoRepository;
    @Id
    @GeneratedValue
    private Long beanNo;
    private String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Bean pojo = (Bean) o;

        if (pojoRepository != null ? !pojoRepository.equals(pojo.pojoRepository) : pojo.pojoRepository != null) {
            return false;
        }
        if (beanNo != null ? !beanNo.equals(pojo.beanNo) : pojo.beanNo != null) {
            return false;
        }
        return description != null ? description.equals(pojo.description) : pojo.description == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (pojoRepository != null ? pojoRepository.hashCode() : 0);
        result = 31 * result + (beanNo != null ? beanNo.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    public BeanRepository getPojoRepository() {

        return pojoRepository;
    }

    public void setPojoRepository(BeanRepository pojoRepository) {
        this.pojoRepository = pojoRepository;
    }
}
