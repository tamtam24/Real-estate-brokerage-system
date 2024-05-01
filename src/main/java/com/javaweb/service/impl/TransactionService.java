package com.javaweb.service.impl;

import com.javaweb.converter.TransactionConverter;
import com.javaweb.entity.CustomerEntity;
import com.javaweb.entity.TransactionEntity;
import com.javaweb.model.dto.TransactionDTO;
import com.javaweb.model.response.ResponseDTO;
import com.javaweb.model.response.TransactionResponseDTO;
import com.javaweb.repository.CustomerRepository;
import com.javaweb.repository.TransactionRepository;
import com.javaweb.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionService implements ITransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private TransactionConverter transactionConverter;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    @Transactional
    public void addOrUpdateTransaction(TransactionDTO transactionDTO) {
        TransactionEntity updatedOrNewTransaction = transactionConverter.dtoConvertToEntity(transactionDTO);
        TransactionEntity transactionEntity;
        if(transactionDTO.getId()!= null){
            transactionEntity = transactionRepository.findById(transactionDTO.getId()).get();
            updatedOrNewTransaction.setCustomer(transactionEntity.getCustomer());
        }
        else{
            CustomerEntity customerEntity = customerRepository.findById(transactionDTO.getCustomerid()).get();
            updatedOrNewTransaction.setCustomer(customerEntity);
        }


        transactionRepository.save(updatedOrNewTransaction);
        System.out.println("addorupdate oke");

    }

    public TransactionDTO findTransactionById(Long id){
        TransactionEntity transactionEntity = transactionRepository.findById(id).get();
        TransactionDTO transactionDTO = transactionConverter.entityCovertToDto(transactionEntity);
        return transactionDTO;
    }

    public List<TransactionDTO> findTransactionByCustomerIdAndCode(Long id,String code){
        List<TransactionEntity>transactionEntities = transactionRepository.findAllByCustomerIdAndCode(id,code);
        List<TransactionDTO>results = new ArrayList<>();
        for(TransactionEntity item:transactionEntities){
            TransactionDTO transactionDTO = transactionConverter.entityCovertToDto(item);
            results.add(transactionDTO);
        }
        return results;
    }

    public TransactionResponseDTO loadTransaction (Long id,Long customerId){
        TransactionEntity transactionEntity = transactionRepository.findByIdAndCustomerId(id,customerId);
        TransactionResponseDTO transactionResponseDTO = new TransactionResponseDTO();
//        ResponseDTO responseDTO = new ResponseDTO();
        transactionResponseDTO.setNote(transactionEntity.getNote());
//        responseDTO.setData(transactionResponseDTO);
//        responseDTO.setMessage("success");

        return transactionResponseDTO;


    }
}
