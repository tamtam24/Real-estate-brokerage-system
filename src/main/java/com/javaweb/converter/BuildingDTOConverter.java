package com.javaweb.converter;

import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.RentAreaEntity;
import com.javaweb.enums.District;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.response.BuildingSearchResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BuildingDTOConverter {


    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private  RentAreaConverter rentAreaConverter;

    public BuildingDTO toBuildingDTO_forUpdateBuilding(BuildingEntity item) {
        BuildingDTO building = modelMapper.map(item, BuildingDTO.class);
//        building.setAddress(item.getStreet() + "," + item.getWard() + "," + item.getDistrict());
        List<RentAreaEntity> rentAreas = item.getItems();
        String areaResult = rentAreas.stream().map(it -> it.getValue()).collect(Collectors.joining(","));
        building.setRentArea(areaResult);
        String []typeCodes=item.getType().split(",");
        List<String>listTypeCode = new ArrayList<>();
        for(String str:typeCodes){
            listTypeCode.add(str);
        }
        building.setTypeCode(listTypeCode);

        return building;
    }

//    public BuildingDTO toBuildingDTO(BuildingEntity item) {
//        BuildingDTO building = modelMapper.map(item, BuildingDTO.class);
////        building.setAddress(item.getStreet() + "," + item.getWard() + "," + item.getDistrict());
//        List<RentAreaEntity> rentAreas = item.getItems();
//        String areaResult = rentAreas.stream().map(it -> it.getValue().toString()).collect(Collectors.joining(","));
////        building.setRentArea(areaResult);
//        return building;
//    }

    public BuildingSearchResponse toBuildingResponce(BuildingEntity item) {
        BuildingSearchResponse building = modelMapper.map(item, BuildingSearchResponse.class);
        if (item.getDistrict() != null) {
            String districtKey = item.getDistrict();
            String districtValue = District.type().get(districtKey);
            building.setAddress(item.getStreet() + "," + item.getWard() + "," + districtValue);
        } else {
            building.setAddress(item.getStreet() + "," + item.getWard() );
        }
        List<RentAreaEntity> rentAreas = item.getItems();
        String areaResult = rentAreas.stream().map(it -> it.getValue()).collect(Collectors.joining(","));
        building.setRentArea(areaResult);
        return building;
    }


    public BuildingEntity toBuildingEntity(BuildingDTO item) {
        BuildingEntity building = modelMapper.map(item, BuildingEntity.class);

//        String typeCodeString="";
        String typeCodeStringJoin = item.getTypeCode().stream().collect(Collectors.joining(","));
//        for (String str:item.getTypeCode()){
//            typeCodeString+= str+ ",";
//        }
//        if (typeCodeString!="") {
//            typeCodeString = typeCodeString.substring(0, typeCodeString.length() - 1);
//        }
        building.setType(typeCodeStringJoin);
        List<RentAreaEntity>rentAreaEntities = rentAreaConverter.setToEntity(item,building);
        building.setItems(rentAreaEntities);

        return building;

    }

    public BuildingEntity entityToEntity(BuildingEntity oldBuilding,BuildingEntity newBuilding){

        oldBuilding = modelMapper.map(newBuilding,oldBuilding.getClass());
        oldBuilding.removeRentArea(oldBuilding.getItems());
//        for (RentAreaEntity rentAreaEntity : oldBuilding.getItems()) {
//            rentAreaEntity.setBuilding(oldBuilding);
//            System.out.println("luu rentArea oke");
//        }
        oldBuilding.setItems(newBuilding.getItems());

        return oldBuilding;
    }
}