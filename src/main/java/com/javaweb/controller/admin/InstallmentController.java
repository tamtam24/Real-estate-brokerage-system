package com.javaweb.controller.admin;

import com.javaweb.constant.SystemConstant;
import com.javaweb.enums.Status;
import com.javaweb.model.dto.CustomerDTO;
import com.javaweb.model.dto.InstallmentDTO;
import com.javaweb.model.dto.UserDTO;
import com.javaweb.service.IInstallmentService;
import com.javaweb.utils.DisplayTagUtils;
import com.javaweb.utils.MessageUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @GetMapping(value = "admin/installment-edit")
    public ModelAndView installmentEdit (@ModelAttribute("installmentEdit") InstallmentDTO installmentDTO, HttpServletRequest request){
        ModelAndView mav = new ModelAndView("admin/installment/edit");
        mav.addObject("statuss", Status.statusType());
        return mav;
    }
    @RequestMapping(value = "admin/installment-list", method = RequestMethod.GET)
    public ModelAndView installmentList(@ModelAttribute(SystemConstant.MODEL) InstallmentDTO model, HttpServletRequest request) {
        System.out.println("Hello world");

        //Lấy ra view cần hiển thị
        ModelAndView mav = new ModelAndView("admin/installment/list");

        //Cái này k biết là cái gì, mà cứ cop đại cho tất cả cái tương tự đi
        DisplayTagUtils.of(request, model);

        //Lấy dữ liệu từ service

        //Lấy ra danh sách các installments
        List<InstallmentDTO> news = installmentService.findAllInstallments();
        System.out.println("news: " + news);

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
