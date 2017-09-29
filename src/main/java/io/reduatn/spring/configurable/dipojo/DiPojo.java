package io.reduatn.spring.configurable.dipojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 * @author myeongju.jung
 */
@SuppressWarnings({"SpringAutowiredFieldsWarningInspection", "SpringJavaAutowiredMembersInspection"})
@Configurable
@Entity
public class DiPojo {
    @Transient
    @Autowired
    private DiPojoRepository pojoRepository;
    @Id
    @GeneratedValue
    private Long pojoNo;
    private String description;

    public DiPojoRepository getPojoRepository() {
        return pojoRepository;
    }

    public void setPojoRepository(DiPojoRepository pojoRepository) {
        this.pojoRepository = pojoRepository;
    }

    public Long getPojoNo() {
        return pojoNo;
    }

    public void setPojoNo(Long pojoNo) {
        this.pojoNo = pojoNo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DiPojo diPojo = (DiPojo) o;

        if (pojoRepository != null ? !pojoRepository.equals(diPojo.pojoRepository) : diPojo.pojoRepository != null) {
            return false;
        }
        if (pojoNo != null ? !pojoNo.equals(diPojo.pojoNo) : diPojo.pojoNo != null) {
            return false;
        }
        return description != null ? description.equals(diPojo.description) : diPojo.description == null;
    }

    @Override
    public int hashCode() {
        int result = pojoRepository != null ? pojoRepository.hashCode() : 0;
        result = 31 * result + (pojoNo != null ? pojoNo.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
