package me.youdontfind.repositories.common.impl;

import me.youdontfind.repositories.common.CustomRevisionRepository;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import javax.persistence.EntityManager;
import java.io.Serializable;

@NoRepositoryBean
public class CustomRevisionRepositoryImpl<T extends Object, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements CustomRevisionRepository<T, ID> {

    private Class<T> domainClass;
    private EntityManager entityManager;

    private AuditReader getReader() {
        return AuditReaderFactory.get(entityManager);
    }

    public CustomRevisionRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
    }

    public CustomRevisionRepositoryImpl(Class<T> domainClass, EntityManager entityManager) {
        super(domainClass, entityManager);
        this.domainClass = domainClass;
        this.entityManager = entityManager;
    }

    @Override
    public Page<T> findAll(T filterObj, Pageable pageable) {

        Example<T> example = Example.of(filterObj, ExampleMatcher.matching().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING).withIgnoreCase());

        return findAll(example, pageable);
    }
}
