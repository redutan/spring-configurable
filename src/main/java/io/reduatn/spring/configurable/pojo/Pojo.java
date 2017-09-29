package io.reduatn.spring.configurable.pojo;

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
public class Pojo {
    @Transient
    @Autowired
    private PojoRepository pojoRepository;
    @Id
    @GeneratedValue
    private Long pojoNo;
    private String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Pojo pojo = (Pojo) o;

        if (pojoRepository != null ? !pojoRepository.equals(pojo.pojoRepository) : pojo.pojoRepository != null) {
            return false;
        }
        if (pojoNo != null ? !pojoNo.equals(pojo.pojoNo) : pojo.pojoNo != null) {
            return false;
        }
        return description != null ? description.equals(pojo.description) : pojo.description == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (pojoRepository != null ? pojoRepository.hashCode() : 0);
        result = 31 * result + (pojoNo != null ? pojoNo.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    public PojoRepository getPojoRepository() {

        return pojoRepository;
    }

    public void setPojoRepository(PojoRepository pojoRepository) {
        this.pojoRepository = pojoRepository;
    }
}
