package com.javaweb.service;

import com.javaweb.model.dto.AssignmentBuildingDTO;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.model.response.BuildingSearchResponse;
import com.javaweb.model.response.ResponseDTO;

import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Map;

public interface IBuildingService {

    ResponseDTO listStaffs(Long buildingId);

    List<BuildingSearchResponse>findAll(BuildingSearchRequest buildingSearchRequest, Pageable pageable);

//    List<BuildingSearchResponse>searchBuilding(BuildingSearchRequest buildingSearchRequest);

    BuildingDTO findBuildingById(Long id);
//
//    BuildingDTO updateBuilding(BuildingDTO buildingDTO);

    void addOrUpdateBuilding(BuildingDTO buildingDTO);


    void deleteBuildings(List<Long> ids);
    //    void addOrUpdateBuilding(BuildingDTO buildingDTO);
//    void updateAssignmentBuilding(AssignmentBuildingDTO assignmentBuildingDTO);
    int countTotalItem();

    Map<Long,String>getBuildings();


}