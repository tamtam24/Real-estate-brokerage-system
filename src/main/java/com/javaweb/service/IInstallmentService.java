package com.javaweb.service;

import com.javaweb.entity.InstallmentEntity;
import com.javaweb.model.dto.InstallmentDTO;
import com.javaweb.model.dto.InstallmentGroupByCustomerDTO;
import com.javaweb.model.dto.Installment_Building_UserDto;

import java.util.List;


public interface IInstallmentService {
    InstallmentEntity addOrUpdateInstallment(InstallmentDTO installmentDTO);
    void deleteInstallment(List<Long>ids);
    List<Installment_Building_UserDto> findAllInstallments();
    void createAssignmentInstallment(Long installmentId, Long buildingId, Long userId, Long staffId);
    InstallmentDTO findInstallmentById(Long id);
    List<InstallmentGroupByCustomerDTO> findInstallmentGroupByCustomer();
}
