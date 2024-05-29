package com.javaweb.converter;

import com.javaweb.entity.CustomerEntity;
import com.javaweb.enums.Status;
import com.javaweb.model.dto.CustomerDTO;
import com.javaweb.model.response.CustomerSearchResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerConverter {

    @Autowired
    private ModelMapper modelMapper;

    public CustomerEntity dtoConvertToEntity(CustomerDTO customerDTO){
        CustomerEntity customer = modelMapper.map(customerDTO,CustomerEntity.class);
        customer.setFullName(customerDTO.getName());
        customer.setPhone(customerDTO.getCustomerPhone());
        customer.setCompanyname(customerDTO.getCompanyName());
        if(customerDTO.getStatus() =="" ||customerDTO.getStatus() == null){
            customer.setStatus("CHUA_XL");
        }
        return customer;

    }

    public CustomerSearchResponse entityConvertToResponse(CustomerEntity customerEntity){
        CustomerSearchResponse customer = modelMapper.map(customerEntity,CustomerSearchResponse.class);
        customer.setPhone(customerEntity.getPhone());
        customer.setFullname(customerEntity.getFullName());
        if(customerEntity.getStatus()!=""){
            String statusKey = customerEntity.getStatus();
            String statusValue = Status.statusType().get(statusKey);
            customer.setStatus(statusValue);
        }

        return customer;
    }

    public CustomerDTO entityConvertToDto (CustomerEntity customerEntity){
        CustomerDTO customer = modelMapper.map(customerEntity,CustomerDTO.class);
        customer.setName(customerEntity.getFullName());
        customer.setCustomerPhone(customerEntity.getPhone());
        return customer;
    }

}
