package com.raphael.api.ApiSybase.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class ExecuteScript {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void execute(String sql){
        entityManager.createNativeQuery(sql).executeUpdate();
    }
}
