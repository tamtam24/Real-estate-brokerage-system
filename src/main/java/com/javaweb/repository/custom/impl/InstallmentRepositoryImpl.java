package com.javaweb.repository.custom.impl;

import com.javaweb.entity.AssignmentInstallmentEntity;
import com.javaweb.entity.InstallmentEntity;
import com.javaweb.entity.RoleEntity;
import com.javaweb.model.dto.Installment_Building_UserDto;
import com.javaweb.repository.InstallmentRepository;
import com.javaweb.repository.custom.InstallmentRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collections;
import java.util.List;

@Repository
public class InstallmentRepositoryImpl implements InstallmentRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private EntityManagerFactory emf;

    @Override
    public List<InstallmentEntity> findAllByIs_active(int is_active) {
        String sql = "select * FROM installment as i where i.is_active = '" + is_active + "'";
        Query query = entityManager.createNativeQuery(sql, InstallmentEntity.class);
        return (List<InstallmentEntity>) query.getResultList();
    }

    @Override
    public List<AssignmentInstallmentEntity> findAllInstallmentIncludeBuilding() {
        String sql = "SELECT * FROM \n" +
                "assignmentinstallment a_i, installment i, building b, user us, user st\n" +
                "WHERE a_i.installmentid = i.id\n" +
                "AND a_i.userid = us.id\n" +
                "AND a_i.buildingid = b.id\n" +
                "AND a_i.staffid = st.id";
        Query query = entityManager.createNativeQuery(sql, AssignmentInstallmentEntity.class);
        return (List<AssignmentInstallmentEntity>) query.getResultList();
    }

    @Override
    public void createAssignmentInstallment(Long installmentId, Long buildingId, Long userId, Long staffId) {
        String sql = "INSERT INTO assignmentinstallment (installmentid, buildingid, userid, staffid) VALUES (" + installmentId + ", " + buildingId + ", " + userId + ", " + staffId + ")";
        System.out.println("sql: " + sql);
        EntityManager newEntityManager = emf.createEntityManager();
        newEntityManager.getTransaction().begin();
        Query query = newEntityManager.createNativeQuery(sql);
        query.executeUpdate();
        newEntityManager.getTransaction().commit();
        newEntityManager.close();
    }
}
