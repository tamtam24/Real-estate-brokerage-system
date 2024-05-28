package com.javaweb.converter;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.utils.MapUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;


@Component
public class BuildingSearchBuilderConverter {
    public BuildingSearchBuilder toBuildingSearchBuilder(Map<String, Object> params, List<String> typeCode) {
        BuildingSearchBuilder buildingSearchBuilder = new BuildingSearchBuilder.Builder().setName(MapUtils.getObject(params, "name", String.class))
                .setFloorArea(MapUtils.getObject(params, "floorArea", Long.class))
                .setWard(MapUtils.getObject(params, "ward", String.class))
                .setStreet(MapUtils.getObject(params, "street", String.class))
                .setDistrictId(MapUtils.getObject(params, "districtcode", Long.class))
                .setNumberofBasement(MapUtils.getObject(params, "numberofbasement", Integer.class))
                .setTypeCode(typeCode)
                .setManagerName(MapUtils.getObject(params, "managername", String.class))
                .setManagerPhoneNumber(MapUtils.getObject(params, "managerphonenumber", String.class))
                .setRentPriceTo(MapUtils.getObject(params, "rentpriceto", Long.class))
                .setRentPriceFrom(MapUtils.getObject(params, "rentpricefrom", Long.class))
                .setAreaFrom(MapUtils.getObject(params, "areafrom", Long.class))
                .setAreaTo(MapUtils.getObject(params, "areato", Long.class))
                .setStaffId(MapUtils.getObject(params, "staffid", Long.class))
                .build();


        return buildingSearchBuilder;
    }

}

