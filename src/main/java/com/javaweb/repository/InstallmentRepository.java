package com.javaweb.repository;

import com.javaweb.entity.CustomerEntity;
import com.javaweb.entity.InstallmentEntity;
import com.javaweb.repository.custom.CustomerRepositoryCustom;
import com.javaweb.repository.custom.InstallmentRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InstallmentRepository extends JpaRepository<InstallmentEntity,Long>, InstallmentRepositoryCustom {
    //List<InstallmentEntity> findAllByIs_active(int is_active);
}
