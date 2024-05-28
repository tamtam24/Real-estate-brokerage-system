package com.javaweb.repository;

import com.javaweb.entity.RentAreaEntity;
import com.javaweb.repository.custom.RentAreaRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentAreaRepository extends JpaRepository<RentAreaEntity,Long>, RentAreaRepositoryCustom {
    void deleteByBuildingId(Long BuildingId);

}
