package com.javaweb.repository.custom.impl;

import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.UserEntity;
//import com.javaweb.repository.custom.AssignmentBuildingCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;
import java.util.List;

//@Repository
//public class AssignmentBuildingImpl implements AssignmentBuildingCustom {
//
//    @PersistenceContext
//    private EntityManager entityManager;
//
//
////    @Override
////    @Transactional
////    public List<UserEntity> findUsersByBuilding(BuildingEntity buildingEntity) {
////        String sql = "SELECT u.* FROM user u JOIN assignmentbuilding a ON u.id = a.staffid JOIN building b ON a.buildingid = b.id WHERE b.id ="+buildingEntity.getId() +" GROUP BY u.id";
////        Query query = entityManager.createNativeQuery(sql, UserEntity.class);
////
////        return query.getResultList();
//////        List<UserEntity>userEntities = new ArrayList<>();
//////        return  userEntities;
////    }
//
//
//    @Transactional
//    @Override
//    public void deleteAssignmentBuildingEntityByBuilding(BuildingEntity buildingEntity){
//        String sql = "DELETE assignmentbuilding from assignmentbuilding WHERE assignmentbuilding.buildingid = "+buildingEntity.getId();
//        Query query = entityManager.createNativeQuery(sql);
//        query.executeUpdate();
//
//    }
//
//}
