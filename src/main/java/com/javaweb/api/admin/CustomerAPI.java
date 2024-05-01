package com.javaweb.api.admin;


import com.javaweb.model.dto.*;
import com.javaweb.model.response.ResponseDTO;
import com.javaweb.model.response.TransactionResponseDTO;
import com.javaweb.service.ICustomerService;
import com.javaweb.service.ITransactionService;
import com.javaweb.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController(value ="customerAPIOfAdmin")
@RequestMapping("/api/customer")
public class CustomerAPI {
    @Autowired
    private ICustomerService ICustomerService;

    @Autowired
    private IUserService IUserService;

    @Autowired
    private ITransactionService ITransactionService;

    @PostMapping
    public Boolean addOrUpdateCustomer(@RequestBody CustomerDTO customerDTO){

        ICustomerService.addOrUpdateCustomer(customerDTO);
        //xuong db de update boac them  moi
        System.out.println("da them/sua toa nha thanh cong");
        return true;


    }

    //Xoa
    @DeleteMapping("/{ids}")
    public Boolean deleteCustomers(@PathVariable List<Long> ids){
        //xuong db de xoa building theo ds gui ve
        if(ids.size()>0){
            ICustomerService.deleteCustomer(ids);
            System.out.println("oke");
            return true;
        }

        System.out.println("oke");
        return false;

    }
    @GetMapping("/{id}/staffs")
    public ResponseDTO loadStaffs(@PathVariable Long id){
        ResponseDTO result= ICustomerService.listStaffs(id);
        return  result;
    }

    @PostMapping("/assignment")
    public Boolean updateAssignmentCustomer(@RequestBody AssignmentCustomerDTO assignmentCustomerDTO){
        IUserService.updateAssignmentCustomer(assignmentCustomerDTO);
        System.out.println("oke");
        return true;

    }
//
    @PostMapping("/transaction")
    public Boolean addOrUpdateTransaction(@RequestBody TransactionDTO transactionDTO){

        ITransactionService.addOrUpdateTransaction(transactionDTO);
        //xuong db de update boac them  moi
        System.out.println("da them/sua giao dich thanh cong");
        return true;


    }
    @GetMapping("/{customerId}/transaction/{id}")
    public TransactionResponseDTO loadTransaction (@PathVariable Long customerId, @PathVariable Long id){
        TransactionResponseDTO result = ITransactionService.loadTransaction(id,customerId);
        return result;
    }







}
