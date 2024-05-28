package com.javaweb.controller.web;

import com.javaweb.constant.SystemConstant;
import com.javaweb.enums.District;
import com.javaweb.enums.TypeCode;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.model.response.BuildingSearchResponse;
import com.javaweb.security.utils.SecurityUtils;
import com.javaweb.service.IBuildingService;
import com.javaweb.utils.DisplayTagUtils;
import com.javaweb.utils.DistrictCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller(value = "homeControllerOfWeb")
public class HomeController {

    @Autowired
    private com.javaweb.service.IBuildingService IBuildingService;

    @RequestMapping(value = "/trang-chu", method = RequestMethod.GET)
    public ModelAndView homePage(@ModelAttribute(SystemConstant.MODEL) BuildingSearchRequest buildingSearchRequest, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("web/home");
        mav.addObject("modelSearch", buildingSearchRequest);
        mav.addObject("districts", DistrictCode.type());
        List<BuildingSearchResponse> responseList = new ArrayList<>();
        DisplayTagUtils.of(request, buildingSearchRequest);
        responseList = IBuildingService.findAll(buildingSearchRequest, PageRequest.of(buildingSearchRequest.getPage() - 1, buildingSearchRequest.getMaxPageItems()));
        buildingSearchRequest.setListResult(responseList);
        buildingSearchRequest.setTotalItems(IBuildingService.countTotalItem());
        mav.addObject("buildingList", buildingSearchRequest);
        return mav;
    }

    @GetMapping(value = "/gioi-thieu")
    public ModelAndView introducceBuiding() {
        ModelAndView mav = new ModelAndView("web/introduce");
        return mav;
    }

    @GetMapping(value = "/san-pham")
    public ModelAndView buildingList(@ModelAttribute(SystemConstant.MODEL) BuildingSearchRequest buildingSearchRequest, HttpServletRequest request) {
        ModelAndView nav = new ModelAndView("web/list");

        List<BuildingSearchResponse> responseList = new ArrayList<>();
        DisplayTagUtils.of(request, buildingSearchRequest);
        responseList = IBuildingService.findAll(buildingSearchRequest, PageRequest.of(buildingSearchRequest.getPage() - 1, buildingSearchRequest.getMaxPageItems()));
        buildingSearchRequest.setListResult(responseList);
        buildingSearchRequest.setTotalItems(IBuildingService.countTotalItem());
        nav.addObject("buildingList", buildingSearchRequest);
        return nav;
    }

    @GetMapping(value = "/tin-tuc")
    public ModelAndView news() {
        ModelAndView mav = new ModelAndView("/web/news");
        return mav;
    }

    @GetMapping(value = "/lien-he")
    public ModelAndView contact() {
        ModelAndView mav = new ModelAndView("/web/contact");
        return mav;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView("login");
        return mav;
    }

    @RequestMapping(value = "/access-denied", method = RequestMethod.GET)
    public ModelAndView accessDenied() {
        return new ModelAndView("redirect:/login?accessDenied");
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logout(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return new ModelAndView("redirect:/trang-chu");
    }
}
