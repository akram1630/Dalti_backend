package org.example.book.dalti_back.repository;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ServiceSpec implements Specification {

    private String serviceName;

    public ServiceSpec(String serviceName) {
        super();
        this.serviceName = serviceName;
    }

    @Override
    //root: entity //CriteriaQuery: orderBy groupBy .... //Criteriabuilder: condition ex name="sasss"
    public Predicate toPredicate(Root root, CriteriaQuery query, CriteriaBuilder criteriaBuilder) {
        if(serviceName != null && !serviceName.isEmpty()) {
            //return criteriaBuilder.like(root.get("name"),serviceName); //all name should be ex: akra --/-->(akram)
            return criteriaBuilder.like(root.get("name"),"%"+serviceName+"%"); //search by letter ex: a-->(akram , 3yada)
        }
        return null;
    }
}
