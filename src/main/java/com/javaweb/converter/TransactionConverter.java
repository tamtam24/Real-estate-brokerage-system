package com.javaweb.converter;

import com.javaweb.entity.TransactionEntity;
import com.javaweb.model.dto.TransactionDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TransactionConverter {

    @Autowired
    private ModelMapper modelMapper;

    public TransactionEntity dtoConvertToEntity (TransactionDTO transactionDTO){
        TransactionEntity transaction = modelMapper.map(transactionDTO,TransactionEntity.class);
        return transaction;

    }
    public TransactionDTO entityCovertToDto (TransactionEntity transactionEntity){
        TransactionDTO transaction = modelMapper.map(transactionEntity,TransactionDTO.class);
        return transaction;
    }
}
