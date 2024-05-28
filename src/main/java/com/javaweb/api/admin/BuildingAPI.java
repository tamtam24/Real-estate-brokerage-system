package com.javaweb.api.admin;

import com.javaweb.model.dto.AssignmentBuildingDTO;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.model.response.BuildingSearchResponse;
import com.javaweb.model.response.ResponseDTO;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.service.IBuildingService;
import com.javaweb.service.IUserService;
import com.javaweb.service.impl.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController(value = "buildingAPIOfAdmin")
@RequestMapping("/api/building")

public class BuildingAPI {
    @Autowired
    private IBuildingService IBuildingService;

    @Autowired
    private IUserService IUserService;


    //Tim kiem toa nha
    @GetMapping
    public List<BuildingSearchResponse> getBuilding(BuildingSearchRequest buildingSearchRequest,  Pageable pageable) {
        List<BuildingSearchResponse> result = IBuildingService.findAll(buildingSearchRequest,pageable);
        return result;
    }
    //Them hoạc sua toa nha
    @PostMapping
    public Boolean addOrUpdateBuilding(@RequestBody BuildingDTO buildingDTO){

        IBuildingService.addOrUpdateBuilding(buildingDTO);
        //xuong db de update boac them  moi
        System.out.println("da them/sua toa nha thanh cong");
        return true;


    }

    //Xoa toa nha
    @DeleteMapping("/{ids}")
    public Boolean deleteBuilding(@PathVariable List<Long> ids){
        //xuong db de xoa building theo ds gui ve
        IBuildingService.deleteBuildings(ids);
        System.out.println("oke");
        return true;
    }

    @GetMapping("/{id}/staffs")
    public ResponseDTO loadStaffs(@PathVariable Long id){
        ResponseDTO result= IBuildingService.listStaffs(id);
        return  result;
    }

    @PostMapping("/assignment")
    public Boolean updateAssignmentBuilding(@RequestBody AssignmentBuildingDTO assignmentBuildingDTO){
        IUserService.updateAssignmentBuilding(assignmentBuildingDTO);
        System.out.println("oke");
        return true;
//        ResponseDTO responseDTO=new ResponseDTO();
//        responseDTO.setMessage("success");
//        return  responseDTO;
    }

}

