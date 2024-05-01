package com.javaweb.controller.admin;

import com.javaweb.constant.SystemConstant;
import com.javaweb.enums.Status;
import com.javaweb.enums.TransactionType;
import com.javaweb.model.dto.CustomerDTO;
import com.javaweb.model.dto.TransactionDTO;
import com.javaweb.model.request.CustomerSearchRequest;
import com.javaweb.model.response.CustomerSearchResponse;
import com.javaweb.security.utils.SecurityUtils;
import com.javaweb.service.ICustomerService;
import com.javaweb.service.ITransactionService;
import com.javaweb.service.impl.UserService;
import com.javaweb.utils.DisplayTagUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller(value = "customerControllerOfAdmin")
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
    private UserService userService;

    @Autowired
    private ITransactionService iTransactionService;

    @GetMapping(value = "admin/customer-list")
    public ModelAndView customerList (@ModelAttribute (SystemConstant.MODEL)CustomerSearchRequest customerSearchRequest, HttpServletRequest request){
        ModelAndView mav = new ModelAndView("admin/customer/list");
        mav.addObject("modelSearch",customerSearchRequest);
        mav.addObject("ListStaffs",userService.getStaffs());
        List<CustomerSearchResponse>responseList = new ArrayList<>();
        DisplayTagUtils.of(request,customerSearchRequest);
        if (SecurityUtils.getAuthorities().contains("ROLE_STAFF")){
            Long id = SecurityUtils.getPrincipal().getId();
            customerSearchRequest.setStaffid(id);
            responseList = iCustomerService.getCustomers(customerSearchRequest, PageRequest.of(customerSearchRequest.getPage()-1,customerSearchRequest.getMaxPageItems()));
        }
        else {
            responseList = iCustomerService.getCustomers(customerSearchRequest, PageRequest.of(customerSearchRequest.getPage()-1,customerSearchRequest.getMaxPageItems()));
        }

        customerSearchRequest.setListResult(responseList);
        customerSearchRequest.setTotalItems(iCustomerService.countTotalItems());
        mav.addObject("customerList",customerSearchRequest);
        return mav;
    }

    @GetMapping(value = "admin/customer-edit")
    public ModelAndView customerEdit (@ModelAttribute("customerEdit")CustomerDTO customerDTO,HttpServletRequest request){
        ModelAndView mav = new ModelAndView("admin/customer/edit");
        mav.addObject("statuss", Status.statusType());
        return mav;
    }

    @GetMapping(value = "admin/customer-edit-{id}")
    public ModelAndView customerEdit (@PathVariable("id") Long Id , HttpServletRequest request){
        ModelAndView nav = new ModelAndView("admin/customer/edit");
        nav.addObject("statuss", Status.statusType());

        CustomerDTO customerDTO = iCustomerService.findCustomerById(Id);
        nav.addObject("customerEdit",customerDTO);
        nav.addObject("transactionType", TransactionType.transactionType());
//        List<TransactionDTO>responseList = new ArrayList<>() ;
//        responseList = iTransactionService.findAllTransactionByCustomerId(Id);
        List<TransactionDTO>transactionListCSKH= iTransactionService.findTransactionByCustomerIdAndCode(Id,"CSKH");
        nav.addObject("transactionListCSKH",transactionListCSKH);
        List<TransactionDTO>transactionListDDX= iTransactionService.findTransactionByCustomerIdAndCode(Id,"DDX");
        nav.addObject("transactionListDDX",transactionListDDX);



        return nav;
    }

}
