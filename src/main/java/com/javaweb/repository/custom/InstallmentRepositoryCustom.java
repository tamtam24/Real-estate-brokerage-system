package com.javaweb.repository.custom;

import com.javaweb.entity.InstallmentEntity;

import java.util.List;

public interface InstallmentRepositoryCustom {
    List<InstallmentEntity> findAllByIs_active(int is_active);
}
