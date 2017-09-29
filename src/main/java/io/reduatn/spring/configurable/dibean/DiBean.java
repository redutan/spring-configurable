package io.reduatn.spring.configurable.dibean;

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
public class DiBean {
    @Transient
    @Autowired
    private DiBeanRepository pojoRepository;
    @Id
    @GeneratedValue
    private Long beanNo;
    private String description;

    public DiBeanRepository getPojoRepository() {
        return pojoRepository;
    }

    public void setPojoRepository(DiBeanRepository pojoRepository) {
        this.pojoRepository = pojoRepository;
    }

    public Long getBeanNo() {
        return beanNo;
    }

    public void setBeanNo(Long beanNo) {
        this.beanNo = beanNo;
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
        DiBean diPojo = (DiBean) o;

        if (pojoRepository != null ? !pojoRepository.equals(diPojo.pojoRepository) : diPojo.pojoRepository != null) {
            return false;
        }
        if (beanNo != null ? !beanNo.equals(diPojo.beanNo) : diPojo.beanNo != null) {
            return false;
        }
        return description != null ? description.equals(diPojo.description) : diPojo.description == null;
    }

    @Override
    public int hashCode() {
        int result = pojoRepository != null ? pojoRepository.hashCode() : 0;
        result = 31 * result + (beanNo != null ? beanNo.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
