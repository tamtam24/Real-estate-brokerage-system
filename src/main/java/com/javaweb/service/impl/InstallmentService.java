package com.javaweb.service.impl;

import com.javaweb.entity.InstallmentEntity;
import com.javaweb.model.dto.InstallmentDTO;
import com.javaweb.repository.InstallmentRepository;
import com.javaweb.service.IInstallmentService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class InstallmentService implements IInstallmentService {
    private static final Logger log = LoggerFactory.getLogger(InstallmentService.class);
    @Autowired
    private InstallmentRepository installmentRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    @Transactional
    public void addOrUpdateInstallment(InstallmentDTO installmentDTO){
        InstallmentEntity updatedOrNewInstallment = modelMapper.map(installmentDTO, InstallmentEntity.class);
        if(installmentDTO.getStatus() =="" ||installmentDTO.getStatus() == null){
            updatedOrNewInstallment.setStatus("CHUA_XL");
        }
        InstallmentEntity installmentEntity;
        if(installmentDTO.getId() != null){
            installmentEntity = installmentRepository.findById(installmentDTO.getId()).get();
            updatedOrNewInstallment.setAssignmentInstallmentEntityList(installmentEntity.getAssignmentInstallmentEntityList());
        }

        updatedOrNewInstallment.setIs_active(1);
        System.out.println("id"+ updatedOrNewInstallment.getId());
        installmentRepository.save(updatedOrNewInstallment);
        System.out.println("addorupdate oke");

    }

    @Override
    @Transactional
    public void deleteInstallment(List<Long> ids){
        for(Long id : ids){
            InstallmentEntity installmentEntity = installmentRepository.findById(id).get();
            installmentEntity.setIs_active(0);
            installmentRepository.save(installmentEntity);
        }
    }

    @Override
    public List<InstallmentDTO> findAllInstallments(){
        List<InstallmentEntity> list = installmentRepository.findAllByIs_active(1);
        List<InstallmentDTO> results =  new ArrayList<>();
        for(InstallmentEntity item:list){
            InstallmentDTO installmentDTO = modelMapper.map(item, InstallmentDTO.class);
            results.add(installmentDTO);
        }
        return results;
    }
}
