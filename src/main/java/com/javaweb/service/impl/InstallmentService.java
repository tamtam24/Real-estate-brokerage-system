package com.javaweb.service.impl;

import com.javaweb.entity.AssignmentInstallmentEntity;
import com.javaweb.entity.InstallmentEntity;
import com.javaweb.model.dto.InstallmentDTO;
import com.javaweb.model.dto.Installment_Building_UserDto;
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
    public InstallmentEntity addOrUpdateInstallment(InstallmentDTO installmentDTO){
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
        //System.out.println("id ne"+ updatedOrNewInstallment.getId());
        InstallmentEntity installment = installmentRepository.save(updatedOrNewInstallment);
        System.out.println("id ne"+ installment.getId());
        return installment;
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
    public List<Installment_Building_UserDto> findAllInstallments(){
        List<AssignmentInstallmentEntity> list = installmentRepository.findAllInstallmentIncludeBuilding();
       // List<InstallmentEntity> listtest = installmentRepository.findAllInstallmentIncludeBuilding();
       // System.out.println("listest"+ listtest.get(0));
        //List<AssignmentInstallmentEntity> list1 = list.get(0).getAssignmentInstallmentEntityList();
        //System.out.println("list1"+ list1.get(0).getBuildings().getName());
        List<Installment_Building_UserDto> results =  new ArrayList<>();
        for(AssignmentInstallmentEntity item:list){
            Installment_Building_UserDto installmentDTO = modelMapper.map(item, Installment_Building_UserDto.class);
            results.add(installmentDTO);
        }
//        List<InstallmentDTO> results =  new ArrayList<>();
//        for(InstallmentEntity item:list){
//            InstallmentDTO installmentDTO = modelMapper.map(item, InstallmentDTO.class);
//            results.add(installmentDTO);
//        }
        return results;
    }

    @Override
    public void createAssignmentInstallment(Long installmentId, Long buildingId, Long userId, Long staffId) {
        installmentRepository.createAssignmentInstallment(installmentId, buildingId, userId, staffId);
    }

    @Override
    public InstallmentDTO findInstallmentById(Long id) {
        InstallmentEntity installmentEntity = installmentRepository.findById(id).get();
        InstallmentDTO installmentDTO = modelMapper.map(installmentEntity, InstallmentDTO.class);
        return installmentDTO;
    }
}
