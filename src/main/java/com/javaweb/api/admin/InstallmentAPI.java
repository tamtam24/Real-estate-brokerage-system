package com.javaweb.api.admin;

import com.javaweb.entity.AssignmentInstallmentEntity;
import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.InstallmentEntity;
import com.javaweb.model.dto.InstallmentCreationDTO;
import com.javaweb.model.dto.InstallmentDTO;
import com.javaweb.service.IInstallmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController(value = "installmentAPI")
@RequestMapping("/api/installment")
public class InstallmentAPI {
    @Autowired
    private IInstallmentService installmentService;;


    @PostMapping
    public Boolean addOrUpdateIInstallment(@RequestBody InstallmentCreationDTO installmentCreationDTO){
        System.out.println("Hello worlddd");
        InstallmentDTO installmentDTO = new InstallmentDTO();
        if (installmentCreationDTO.getId() != null){
            installmentDTO.setId(installmentCreationDTO.getId());
        }
        installmentDTO.setAmount(installmentCreationDTO.getAmount());
        installmentDTO.setCode(installmentCreationDTO.getCode());
        installmentDTO.setDuedate(installmentCreationDTO.getDuedate());
        installmentDTO.setNote(installmentCreationDTO.getNote());
        installmentDTO.setStatus(installmentCreationDTO.getStatus());
        InstallmentEntity installment = installmentService.addOrUpdateInstallment(installmentDTO);
        Long installmentId = installment.getId();
        Long staffId = installmentCreationDTO.getStaffId();
        Long customerId = installmentCreationDTO.getCustomerId();
        Long buildingId = installmentCreationDTO.getBuildingId();
        System.out.println("building ne"+ buildingId);
        System.out.println("staff ne"+ staffId);
        System.out.println("customer ne"+ customerId);
        System.out.println("installment ne"+ installmentId);
        installmentService.createAssignmentInstallment(installmentId, buildingId, customerId, staffId);
        System.out.println("da them/sua tra gop thanh cong");
        return true;
    }

    @DeleteMapping("/{ids}")
    public Boolean deleteCustomers(@PathVariable List<Long> ids){
        //xuong db de xoa building theo ds gui ve
        for (Long id : ids){
            System.out.println("id ne"+ id);
        }
        if(ids.size()>0){
            installmentService.deleteInstallment(ids);
            System.out.println("oke");
            return true;
        }

        System.out.println("oke");
        return false;

    }



}
