package com.javaweb.repository.custom.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javaweb.entity.AssignmentInstallmentEntity;
import com.javaweb.entity.InstallmentEntity;
import com.javaweb.entity.RoleEntity;
import com.javaweb.model.dto.InstallmentGroupByCustomerDTO;
import com.javaweb.model.dto.Installment_Building_UserDto;
import com.javaweb.repository.InstallmentRepository;
import com.javaweb.repository.custom.InstallmentRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
                "AND i.is_active = 1\n" +
                "AND a_i.userid = us.id\n" +
                "AND a_i.buildingid = b.id\n" +
                "AND a_i.staffid = st.id";
        Query query = entityManager.createNativeQuery(sql, AssignmentInstallmentEntity.class);
        return (List<AssignmentInstallmentEntity>) query.getResultList();
    }

    @Override
    public List<AssignmentInstallmentEntity>findInstallmentByUserId(Long userId){
        String sql = "SELECT * FROM \n" +
                "assignmentinstallment a_i, installment i, building b, user us, user st\n" +
                "WHERE a_i.installmentid = i.id\n" +
                "AND i.is_active = 1\n" +
                "AND a_i.buildingid = b.id\n" +
                "AND a_i.staffid = st.id"+
                "AND a_i.userid = "+userId;
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

    @Override
    public List<InstallmentGroupByCustomerDTO> findInstallmentGroupByCustomer() {
        String sql = "SELECT \n" +
                "\tusr.id customer_id,\n" +
                "\tusr.fullname customer_name, \n" +
                "\tusr.phone customer_phone,\n" +
                "    usr.email customer_email,\n" +
                "    SUM(i.amount) total_amount \n" +
                " FROM\n" +
                "assignmentinstallment a_i, installment i, user usr\n" +
                "WHERE i.is_active = 1\n" +
                "AND a_i.installmentid = i.id\n" +
                "AND usr.id = a_i.userid\n" +
                "GROUP BY usr.id, usr.fullname, usr.phone, usr.email\n" +
                "ORDER BY total_amount DESC";
        Query query = entityManager.createNativeQuery(sql);
        List<Object[]> resultList = query.getResultList();

        List<InstallmentGroupByCustomerDTO> customerReports = new ArrayList<>();
        for (Object[] row : resultList) {
            String customerId = row[0].toString();
            String customerName = (String) row[1];
            String customerPhone = (String) row[2];
            String customerEmail = (String) row[3];
            Long totalAmount = Long.parseLong(row[4].toString());

            InstallmentGroupByCustomerDTO customerReport = new InstallmentGroupByCustomerDTO(customerId, customerName, customerPhone, customerEmail, totalAmount);
            customerReports.add(customerReport);
        }


        return customerReports;
    }
}
