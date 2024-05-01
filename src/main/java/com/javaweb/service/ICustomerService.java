package com.javaweb.service;

import com.javaweb.model.dto.*;
import com.javaweb.model.request.CustomerSearchRequest;
import com.javaweb.model.response.CustomerSearchResponse;
import com.javaweb.model.response.ResponseDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {

    void addOrUpdateCustomer(CustomerDTO customerDTO);
    void deleteCustomer(List<Long>ids);
    List<CustomerSearchResponse>getCustomers(CustomerSearchRequest customerSearchRequest, Pageable pageable);
    ResponseDTO listStaffs(Long customerId);
    CustomerDTO findCustomerById(Long id);
    int countTotalItems();
}
