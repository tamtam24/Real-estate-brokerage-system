package com.javaweb.controller.admin;



import com.javaweb.constant.SystemConstant;
import com.javaweb.enums.District;
import com.javaweb.enums.TypeCode;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.model.response.BuildingSearchResponse;
import com.javaweb.security.utils.SecurityUtils;
import com.javaweb.service.IBuildingService;
import com.javaweb.service.IUserService;
import com.javaweb.utils.DisplayTagUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller(value="buildingControllerOfAdmin")
public class BuildingController {
    @Autowired
    private IUserService userService;

    @Autowired
    private IBuildingService IBuildingService;



    @GetMapping (value="admin/building-list")
    public ModelAndView buildingList(@ModelAttribute (SystemConstant.MODEL)  BuildingSearchRequest buildingSearchRequest, HttpServletRequest request){
        ModelAndView nav = new ModelAndView("admin/building/list");


        nav.addObject("modelSearch",buildingSearchRequest);
        nav.addObject("ListStaffs",userService.getStaffs());
        nav.addObject("districts", District.type());
        nav.addObject("typeCodes", TypeCode.type());
        List<BuildingSearchResponse>responseList = new ArrayList<>() ;
        DisplayTagUtils.of(request, buildingSearchRequest);
        if(SecurityUtils.getAuthorities().contains("ROLE_STAFF")){
            Long staffId = SecurityUtils.getPrincipal().getId();
            buildingSearchRequest.setStaffId(staffId);
            responseList = IBuildingService.findAll(buildingSearchRequest, PageRequest.of(buildingSearchRequest.getPage() - 1, buildingSearchRequest.getMaxPageItems()));
        }

        else{//MANAGER
            responseList = IBuildingService.findAll(buildingSearchRequest, PageRequest.of(buildingSearchRequest.getPage() - 1, buildingSearchRequest.getMaxPageItems()));
        }

        buildingSearchRequest.setListResult(responseList);
        buildingSearchRequest.setTotalItems(IBuildingService.countTotalItem());
        nav.addObject("buildingList",buildingSearchRequest);
        return  nav;
    }

    @GetMapping (value="admin/building-edit")
    public ModelAndView buildingEdit(@ModelAttribute("buildingEdit") BuildingDTO buildingDTO , HttpServletRequest request){
        ModelAndView nav = new ModelAndView("admin/building/edit");
        nav.addObject("districts", District.type());
        nav.addObject("typeCodes", TypeCode.type());

        return  nav;

    }

    @GetMapping (value="admin/building-edit-{id}")
    public ModelAndView buildingEdit(@PathVariable("id") Long Id , HttpServletRequest request){
        ModelAndView nav = new ModelAndView("admin/building/edit");
        BuildingDTO buildingDTO = IBuildingService.findBuildingById(Id);
        nav.addObject("buildingEdit",buildingDTO);
        nav.addObject("districts", District.type());
        nav.addObject("typeCodes", TypeCode.type());

        return  nav;

    }



}
