package com.javaweb.service.impl;

import com.javaweb.converter.CustomerConverter;
import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.CustomerEntity;
import com.javaweb.entity.UserEntity;
import com.javaweb.model.dto.CustomerDTO;
import com.javaweb.model.dto.TransactionDTO;
import com.javaweb.model.request.CustomerSearchRequest;
import com.javaweb.model.response.CustomerSearchResponse;
import com.javaweb.model.response.ResponseDTO;
import com.javaweb.model.response.StaffResponseDTO;
import com.javaweb.repository.CustomerRepository;
import com.javaweb.repository.UserRepository;
import com.javaweb.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerConverter customerConverter;

    @Autowired
    private UserRepository userRepository;


//tim kiem
    @Override
    public List<CustomerSearchResponse>getCustomers(CustomerSearchRequest customerSearchRequest, Pageable pageable){
        List<CustomerEntity> customerEntities = customerRepository.findCustomers(customerSearchRequest,pageable);
        List<CustomerSearchResponse> result = new ArrayList<>();
        for (CustomerEntity item: customerEntities){
            CustomerSearchResponse customer = customerConverter.entityConvertToResponse(item);
            result.add(customer);
        }
        return result;

    }

    //them hoac update
    @Override
    @Transactional
    public void addOrUpdateCustomer(CustomerDTO customerDTO){
        CustomerEntity updatedOrNewCustomer = customerConverter.dtoConvertToEntity(customerDTO);
        CustomerEntity customerEntity;
        if(customerDTO.getId() != null){
            customerEntity = customerRepository.findById(customerDTO.getId()).get();
            updatedOrNewCustomer.setStaffs(customerEntity.getStaffs());
        }
        updatedOrNewCustomer.setIs_active(1);
        customerRepository.save(updatedOrNewCustomer);
        System.out.println("addorupdate oke");
    }
//xoa
    @Override
    @Transactional
    public void deleteCustomer(List<Long>ids){
        for(Long it:ids){
            CustomerEntity customerEntity = customerRepository.findById(it).get();
            customerEntity.setIs_active(0);
            customerRepository.save(customerEntity);

        }
//        customerRepository.deleteByIdIn(ids);
    }

    @Override
    public ResponseDTO listStaffs(Long customerId) {
        CustomerEntity customer = customerRepository.findById(customerId).get();
        List<UserEntity> staffs = userRepository.findByStatusAndRoles_Code(1, "STAFF");
//        List<UserEntity> staffAssignment = userRepository.findUsersByBuilding(building);
        List<UserEntity> staffAssignment = customer.getStaffs();
        List<StaffResponseDTO> staffResponseDTOS = new ArrayList<>();
        ResponseDTO responseDTO = new ResponseDTO();
        for (UserEntity it : staffs) {
            StaffResponseDTO staffResponseDTO = new StaffResponseDTO();
            staffResponseDTO.setFullName(it.getFullName());
            staffResponseDTO.setStaffId(it.getId());
            if (staffAssignment.contains(it)) {
                staffResponseDTO.setChecked("checked");
            } else {
                staffResponseDTO.setChecked("");
            }
            staffResponseDTOS.add(staffResponseDTO);
        }
        responseDTO.setData(staffResponseDTOS);
        responseDTO.setMessage("success");
        return responseDTO;

    }

    public CustomerDTO findCustomerById(Long id){
        CustomerEntity customerEntity = customerRepository.findById(id).get();
        CustomerDTO customerDTO = customerConverter.entityConvertToDto(customerEntity);

        return customerDTO;

    }

    public int countTotalItems(){
        return customerRepository.countTotalItem();
    }





}
