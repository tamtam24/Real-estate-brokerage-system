package com.javaweb.service;

import com.javaweb.model.dto.TransactionDTO;
import com.javaweb.model.response.ResponseDTO;
import com.javaweb.model.response.TransactionResponseDTO;

import java.util.List;

public interface ITransactionService {
    void addOrUpdateTransaction(TransactionDTO transactionDTO);
    TransactionDTO findTransactionById(Long id);
    List<TransactionDTO> findTransactionByCustomerIdAndCode(Long id,String code);
    TransactionResponseDTO loadTransaction (Long id, Long customerid);

}
