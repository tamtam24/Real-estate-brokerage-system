package com.javaweb.repository.custom.impl;

import com.javaweb.entity.InstallmentEntity;
import com.javaweb.entity.RoleEntity;
import com.javaweb.repository.InstallmentRepository;
import com.javaweb.repository.custom.InstallmentRepositoryCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collections;
import java.util.List;

@Repository
public class InstallmentRepositoryImpl implements InstallmentRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<InstallmentEntity> findAllByIs_active(int is_active) {
        String sql = "select * FROM installment as i where i.is_active = '" + is_active + "'";
        Query query = entityManager.createNativeQuery(sql, InstallmentEntity.class);
        return (List<InstallmentEntity>) query.getResultList();
    }
}
