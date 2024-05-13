package com.javaweb.service;

import com.javaweb.model.dto.InstallmentDTO;

import java.util.List;


public interface IInstallmentService {
    void addOrUpdateInstallment(InstallmentDTO installmentDTO);
    void deleteInstallment(List<Long>ids);
    List<InstallmentDTO> findAllInstallments();
}
