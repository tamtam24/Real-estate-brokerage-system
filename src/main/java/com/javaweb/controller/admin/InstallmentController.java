package com.javaweb.controller.admin;

import com.javaweb.constant.SystemConstant;
import com.javaweb.enums.Status;
import com.javaweb.enums.TransactionType;
import com.javaweb.model.dto.*;
import com.javaweb.security.utils.SecurityUtils;
import com.javaweb.service.IInstallmentService;
import com.javaweb.utils.DisplayTagUtils;
import com.javaweb.utils.MessageUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller(value = "installmentControllerOfAdmin")
public class InstallmentController {

    @Autowired
    private IInstallmentService installmentService;

    @Autowired
    private MessageUtils messageUtil;

    @GetMapping(value = "admin/installment-edit-{id}")
    public ModelAndView installmentEdit (@PathVariable("id") Long Id , HttpServletRequest request){
        ModelAndView nav = new ModelAndView("admin/installment/edit-custom");
        nav.addObject("statuss", Status.statusType());

        InstallmentDTO installmentDTO = installmentService.findInstallmentById(Id);
        nav.addObject("installmentEdit",installmentDTO);
        return nav;
    }

    @GetMapping(value = "admin/installment-edit")
    public ModelAndView installmentEdit (@ModelAttribute("installmentEdit") InstallmentCreationDTO installmentCreationDTO, HttpServletRequest request){
        ModelAndView mav = new ModelAndView("admin/installment/edit");
        mav.addObject("statuss", Status.statusType());
        mav.addObject("id", null);
        return mav;
    }

    @RequestMapping(value = "/installment-view", method = RequestMethod.GET)
    public ModelAndView showInstallmentView (@ModelAttribute(SystemConstant.MODEL)Installment_Building_UserDto model,HttpServletRequest request){
        ModelAndView mav = new ModelAndView("web/installment-view");
        DisplayTagUtils.of(request, model);
        if(SecurityUtils.getAuthorities().contains("ROLE_INSTALLMENT_USER")){
            Long userId = SecurityUtils.getPrincipal().getId();
            List<Installment_Building_UserDto> news = installmentService.findInstallmentsByUserId(userId);
            model.setListResult(news);
            mav.addObject(SystemConstant.MODEL, model);
            initMessageResponse(mav, request);
        }

        return mav;
    }



    //GET Installment list
    @RequestMapping(value = "admin/installment-list", method = RequestMethod.GET)
    public ModelAndView installmentList(@ModelAttribute(SystemConstant.MODEL) Installment_Building_UserDto model, HttpServletRequest request) {
        System.out.println("Hello world");

        //Lấy ra view cần hiển thị
        ModelAndView mav = new ModelAndView("admin/installment/list");

        //Cái này k biết là cái gì, mà cứ cop đại cho tất cả cái tương tự đi
        DisplayTagUtils.of(request, model);

        //Lấy dữ liệu từ service

        //Lấy ra danh sách các installments
        List<Installment_Building_UserDto> news = installmentService.findAllInstallments();
        System.out.println("news: " + news);
        System.out.println("so luong" + news.size());

        //Đổ data vào dto
        model.setListResult(news);

        //Đổ tổng số installments vào dto
        //model.setTotalItems(installmentService.countTotalItems());
        mav.addObject(SystemConstant.MODEL, model);
        initMessageResponse(mav, request);
        return mav;
    }

    //GET Installment Group By Customer
    //GET Installment list
    @RequestMapping(value = "admin/installment-group-by-customer-list", method = RequestMethod.GET)
    public ModelAndView installmentGroupByCustomerList(@ModelAttribute(SystemConstant.MODEL) InstallmentGroupByCustomerDTO model, HttpServletRequest request) {
        System.out.println("Hello world");

        //Lấy ra view cần hiển thị
        ModelAndView mav = new ModelAndView("admin/installment/list-group-by-customer");

        //Cái này k biết là cái gì, mà cứ cop đại cho tất cả cái tương tự đi
        DisplayTagUtils.of(request, model);

        //Lấy dữ liệu từ service

        //Lấy ra danh sách các installments
        List<InstallmentGroupByCustomerDTO> news = installmentService.findInstallmentGroupByCustomer();

        //Đổ data vào dto
        model.setListResult(news);

        //Đổ tổng số installments vào dto
        //model.setTotalItems(installmentService.countTotalItems());
        mav.addObject(SystemConstant.MODEL, model);
        initMessageResponse(mav, request);
        return mav;
    }
    private void initMessageResponse(ModelAndView mav, HttpServletRequest request) {
        String message = request.getParameter("message");
        if (message != null && StringUtils.isNotEmpty(message)) {
            Map<String, String> messageMap = messageUtil.getMessage(message);
            mav.addObject(SystemConstant.ALERT, messageMap.get(SystemConstant.ALERT));
            mav.addObject(SystemConstant.MESSAGE_RESPONSE, messageMap.get(SystemConstant.MESSAGE_RESPONSE));
        }
    }
}
