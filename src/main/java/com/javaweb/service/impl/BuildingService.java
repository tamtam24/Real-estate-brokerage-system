package com.javaweb.service.impl;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.converter.BuildingDTOConverter;
import com.javaweb.converter.BuildingSearchBuilderConverter;
import com.javaweb.entity.AssignmentBuildingEntity;
import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.RentAreaEntity;
import com.javaweb.entity.UserEntity;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.model.response.BuildingSearchResponse;
import com.javaweb.model.response.ResponseDTO;
import com.javaweb.model.response.StaffResponseDTO;
//import com.javaweb.repository.AssignmentBuildingRepository;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.RentAreaRepository;
import com.javaweb.repository.UserRepository;
import com.javaweb.service.IBuildingService;
import com.javaweb.utils.UploadFileUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BuildingService implements IBuildingService {
    @Autowired
    private BuildingRepository buildingRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BuildingDTOConverter buildingDTOConverter;

    @Autowired
    private BuildingSearchBuilderConverter buildingSearchBuilderConverter;

//    @Autowired
//    private AssignmentBuildingRepository assignmentBuildingRepository;

    @Autowired
    private RentAreaRepository rentAreaRepository;

    @Autowired
    private UploadFileUtils uploadFileUtils;


    @Override
    public ResponseDTO listStaffs(Long buildingId) {
        BuildingEntity building = buildingRepository.findById(buildingId).get();
        List<UserEntity> staffs = userRepository.findByStatusAndRoles_Code(1, "STAFF");
//        List<UserEntity> staffAssignment = userRepository.findUsersByBuilding(building);
        List<UserEntity> staffAssignment = building.getUserEntities();
        List<StaffResponseDTO> staffResponseDTOS = new ArrayList<>();
        ResponseDTO responseDTO = new ResponseDTO();
        for (UserEntity it : staffs) {
            StaffResponseDTO staffResponseDTO = new StaffResponseDTO();
            staffResponseDTO.setFullName(it.getFullName());
            staffResponseDTO.setStaffId(it.getId());
            if (staffAssignment.contains(it)) {
                staffResponseDTO.setChecked("checked");
            } else {
                staffResponseDTO.setChecked("");
            }
            staffResponseDTOS.add(staffResponseDTO);
        }
        responseDTO.setData(staffResponseDTOS);
        responseDTO.setMessage("success");
        return responseDTO;

    }

    @Override
    public int countTotalItem() {
        return buildingRepository.countTotalItem();
    }

    @Override
    public List<BuildingSearchResponse> findAll(BuildingSearchRequest buildingSearchRequest, Pageable pageable) {
//        BuildingSearchBuilder buildingSearchBuilder=buildingSearchBuilderConverter.toBuildingSearchBuilder(params, typeCode);
        List<BuildingEntity> buildingEntities = buildingRepository.findAllBuilding(buildingSearchRequest, pageable);
        List<BuildingSearchResponse> result = new ArrayList<BuildingSearchResponse>();
        for (BuildingEntity item : buildingEntities) {
            BuildingSearchResponse building = buildingDTOConverter.toBuildingResponce(item);
            result.add(building);
        }
        return result;
    }

    @Override
    @Transactional
    public void deleteBuildings(List<Long> ids) {


//            buildingRepository.deleteRentAreaByBuildingId(id);
//            buildingRepository.deleteAssignmentByBuildingId(id);
            buildingRepository.deleteByIdIn(ids);




    }

    @Override
    @Transactional
    public void addOrUpdateBuilding(BuildingDTO buildingDTO) {
        BuildingEntity updatedOrNewBuilding = buildingDTOConverter.toBuildingEntity(buildingDTO);
        BuildingEntity existingBuilding;
        if (buildingDTO.getId() != null) {
            existingBuilding = buildingRepository.findById(buildingDTO.getId()).get();
            updatedOrNewBuilding.setImage(existingBuilding.getImage());
            updatedOrNewBuilding.setUserEntities(existingBuilding.getUserEntities());
        }
        saveThumbnail(buildingDTO, updatedOrNewBuilding);

//        existingBuilding = buildingDTOConverter.entityToEntity(existingBuilding, updatedOrNewBuilding);
        buildingRepository.save(updatedOrNewBuilding);
        System.out.println("oke here");
//        rentAreaRepository.deleteByBuildingId(existingBuilding.getId());


        //update building

//        if(buildingDTO.getId()!=null){
//            BuildingEntity existingBuilding = buildingRepository.findById(buildingDTO.getId()).get();
//            BuildingEntity updatedBuilding = buildingDTOConverter.toBuildingEntity(buildingDTO);
//
//            existingBuilding= buildingDTOConverter.entityToEntity(existingBuilding,updatedBuilding);
//
//            if (updatedBuilding.getItems()!=null) {
//                rentAreaRepository.deleteByBuildingId(existingBuilding.getId());
//
//                for (RentAreaEntity rentAreaEntity : existingBuilding.getItems()) {
//                    rentAreaEntity.setBuilding(existingBuilding);
//                    rentAreaRepository.save(rentAreaEntity);
//                    System.out.println("sua rentArea oke");
//                }
//
//            }
//
//            buildingRepository.save(existingBuilding);
//        }
//        //adding new building
//        else {
//            BuildingEntity newBuilding= buildingDTOConverter.toBuildingEntity(buildingDTO);
//            buildingRepository.save(newBuilding);
//            if (newBuilding.getItems()!=null) {
//                for (RentAreaEntity rentAreaEntity : newBuilding.getItems()) {
//                    rentAreaEntity.setBuilding(newBuilding);
//                    rentAreaRepository.save(rentAreaEntity);
//                    System.out.println("luu rentArea oke");
//                }
//            }
//            System.out.println("oke here");
//        }


    }

    public BuildingDTO findBuildingById(Long id) {
        BuildingEntity buildingEntity = buildingRepository.findById(id).get();
        BuildingDTO buildingDTO = buildingDTOConverter.toBuildingDTO_forUpdateBuilding(buildingEntity);


        return buildingDTO;
    }

    private void saveThumbnail(BuildingDTO buildingDTO, BuildingEntity buildingEntity) {
        String path = "/building/" + buildingDTO.getImageName();
        if (null != buildingDTO.getImageBase64()) {
            if (null != buildingEntity.getImage()) {
                if (!path.equals(buildingEntity.getImage())) {
                    File file = new File("D://Devops Learning/Java Spring/Picture" + buildingEntity.getImage());
                    file.delete();
                }
            }
            byte[] bytes = Base64.decodeBase64(buildingDTO.getImageBase64().getBytes());
            uploadFileUtils.writeOrUpdate(path, bytes);
            buildingEntity.setImage(path);
        }


    }
    //load danh sach toa nha dang ban len trang tim kiem
    public Map<Long,String>getBuildings(){
     Map<Long,String> buildings = new HashMap<>();
     List<BuildingEntity> buildingEntities = buildingRepository.findAll();
     for(BuildingEntity buildingEntity : buildingEntities){
         buildings.put(buildingEntity.getId(),buildingEntity.getName());
     }
     return buildings;
    }
}
