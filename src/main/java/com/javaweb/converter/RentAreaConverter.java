package com.javaweb.converter;

import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.RentAreaEntity;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.utils.StringUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RentAreaConverter {
    public List<RentAreaEntity> setToEntity(BuildingDTO buildingDTO, BuildingEntity buildingEntity){
        List<RentAreaEntity>rentAreaEntities = new ArrayList<>();
        if(StringUtils.check(buildingDTO.getRentArea())){
            String[] rentAreas = buildingDTO.getRentArea().split(",");
            for(String area:rentAreas){
                RentAreaEntity rentAreaEntity= new RentAreaEntity();
                rentAreaEntity.setBuilding(buildingEntity);
                rentAreaEntity.setValue(area);
                rentAreaEntities.add(rentAreaEntity);
            }
        }
        return  rentAreaEntities;
    }
}
