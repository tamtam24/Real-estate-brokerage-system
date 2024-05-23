package com.javaweb.api.admin;

import com.javaweb.entity.InstallmentEntity;
import com.javaweb.model.dto.InstallmentDTO;
import com.javaweb.service.IInstallmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController(value = "installmentAPI")
@RequestMapping("/api/installment")
public class InstallmentAPI {
    @Autowired
    private IInstallmentService installmentService;;


    @PostMapping
    public Boolean addOrUpdateIInstallment(@RequestBody InstallmentDTO installmentDTO){
        System.out.println("Hello worlddd");
        System.out.println(installmentDTO.getCode());
        installmentService.addOrUpdateInstallment(installmentDTO);
        System.out.println("da them/sua tra gop thanh cong");
        return true;
    }

    @DeleteMapping("/{ids}")
    public Boolean deleteCustomers(@PathVariable List<Long> ids){
        //xuong db de xoa building theo ds gui ve
        if(ids.size()>0){
            installmentService.deleteInstallment(ids);
            System.out.println("oke");
            return true;
        }

        System.out.println("oke");
        return false;

    }



}
