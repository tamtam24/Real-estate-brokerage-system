package com.javaweb.repository.custom;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.entity.BuildingEntity;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.model.response.BuildingSearchResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BuildingRepositoryCustom {
    void deleteRentAreaByBuildingId(Long id);
    void deleteAssignmentByBuildingId(Long id);
    List<BuildingEntity> findAllBuilding(BuildingSearchRequest buildingSearchRequest, Pageable pageable);
    int countTotalItem();


}
