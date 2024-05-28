package com.javaweb.repository;

import com.javaweb.entity.TransactionEntity;
import com.javaweb.repository.custom.TransactionRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<TransactionEntity, Long>, TransactionRepositoryCustom {
    List<TransactionEntity>findAllByCustomerIdAndCode(Long CustomerId,String code);
    TransactionEntity findByIdAndCustomerId(Long Id,Long CustomerId);
}
