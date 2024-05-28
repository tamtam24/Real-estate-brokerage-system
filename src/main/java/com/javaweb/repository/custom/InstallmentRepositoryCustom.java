package com.javaweb.repository.custom;

import com.javaweb.entity.AssignmentInstallmentEntity;
import com.javaweb.entity.InstallmentEntity;
import com.javaweb.model.dto.InstallmentGroupByCustomerDTO;
import com.javaweb.model.dto.Installment_Building_UserDto;

import java.util.List;

public interface InstallmentRepositoryCustom {
    List<InstallmentEntity> findAllByIs_active(int is_active);
    List<AssignmentInstallmentEntity> findAllInstallmentIncludeBuilding();
    void createAssignmentInstallment(Long installmentId, Long buildingId, Long userId, Long staffId);
    List<InstallmentGroupByCustomerDTO> findInstallmentGroupByCustomer();
}
