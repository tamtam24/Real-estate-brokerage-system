package com.javaweb.repository.custom.impl;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.entity.BuildingEntity;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.repository.custom.BuildingRepositoryCustom;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@Primary

public class BuildingRepositoryImpl implements BuildingRepositoryCustom {
//
    @PersistenceContext
    private EntityManager entityManager;


    public static void joinTable(BuildingSearchRequest buildingSearchRequest, StringBuilder sql) {
//        Long staffId = buildingSearchBuilder.getStaffId();
        Long staffId = buildingSearchRequest.getStaffId();
        if (staffId!=null) {
            sql.append("  INNER JOIN assignmentbuilding a ON b.id = a.buildingid ");
        }
//        List<String> typeCode = buildingSearchBuilder.getTypeCode();
//        List<String> typeCode = buildingSearchRequest.getTypeCode();
//        if (typeCode != null && typeCode.size() != 0) {
//            sql.append(" INNER JOIN buildingrenttype ON b.id = buildingrenttype.buildingid ");
//            sql.append(" INNER JOIN renttype  ON renttype.id=buildingrenttype.renttypeid ");
//        }
    }


    public static void queryNormal(BuildingSearchRequest buildingSearchRequest, StringBuilder where) {


        try {
//            Field[]fields = BuildingSearchBuilder.class.getDeclaredFields();
            Field[]fields = buildingSearchRequest.getClass().getDeclaredFields();
            for(Field item:fields) {
                item.setAccessible(true);
                String fieldName=item.getName();
                if (!fieldName.equals("staffId") && !fieldName.startsWith("area")
                        && !fieldName.startsWith("rentPrice") && !fieldName.equals("typeCode")) {
                    Object value = item.get(buildingSearchRequest);
                    if (value!=null && value !="") {
                        if (item.getType().getName().equals("java.lang.Long")||item.getType().getName().equals("java.lang.Integer")||item.getType().getName().equals("java.lang.Float")) {
                            where.append(" AND b." + fieldName + " = " + value);
                        } else if(item.getType().getName().equals("java.lang.String")) {
                            where.append(" AND b." + fieldName+ " LIKE '%" + value + "%' ");
                        }
                    }

                }
            }
        }catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void querySpecial(BuildingSearchRequest buildingSearchRequest, StringBuilder where) {

        Long staffId = buildingSearchRequest.getStaffId();

        if (staffId!=null) {
            where.append(" AND a.staffid = " + staffId + " ");


        }
        Long rentAreaTo = buildingSearchRequest.getAreaTo();
        Long rentAreaFrom = buildingSearchRequest.getAreaFrom();
        if (rentAreaTo!=null || rentAreaFrom!=null) {
            where.append(" AND EXISTS ( SELECT * from rentarea r WHERE b.id = r.buildingid ");
            if (rentAreaFrom!=null) {
                where.append(" AND r.value >= " + rentAreaFrom);

            }
            if (rentAreaTo!=null) {
                where.append(" AND r.value <= " + rentAreaTo);

            }
            where.append(" ) ");
        }
        Long rentPriceTo = buildingSearchRequest.getRentPriceTo();
        Long rentPriceFrom = buildingSearchRequest.getRentPriceFrom();
        if (rentPriceTo!=null || rentPriceFrom!=null) {
            if (rentPriceFrom!=null) {
                where.append(" AND b.rentprice >=" + rentPriceFrom);

            }
            if (rentPriceTo!=null) {
                where.append(" AND b.rentprice <=" + rentPriceTo);

            }
        }
        // java 7
        List<String>typeCode = buildingSearchRequest.getTypeCode();
		if (typeCode != null && typeCode.size() != 0) {

			for(String item:typeCode){
			    where.append("  AND b.type like '%" +item+"%' ");
            }
		}
        // java 8
//        List<String>typeCode = buildingSearchRequest.getTypeCode();
//        if (typeCode != null && typeCode.size() != 0) {
//            where.append(" AND (");
//            String sql = typeCode.stream().map(it -> "b.type Like" + "'%" + it + "%'  ")
//                    .collect(Collectors.joining(" OR "));
//            where.append(sql);
//            where.append(" ) ");
//        }
    }

    @Override
    public List<BuildingEntity> findAllBuilding(BuildingSearchRequest buildingSearchRequest, Pageable pageable) {

        StringBuilder sql = new StringBuilder("SELECT b.* FROM building b  ");
        joinTable(buildingSearchRequest, sql);
        StringBuilder where = new StringBuilder(" WHERE 1=1 ");
        queryNormal(buildingSearchRequest, where);
        querySpecial(buildingSearchRequest, where);
        where.append(" GROUP BY b.id ");
        if (pageable != null) {
            int t = pageable.getPageSize();
            Long m = pageable.getOffset();
            sql.append(where).append(" LIMIT "+ t) .append(" OFFSET "+ m );
        } else {
            sql.append(where);
        }
        sql.append(" ; ");
        Query query = entityManager.createNativeQuery(sql.toString(),BuildingEntity.class);

        return query.getResultList();

    }



    @Transactional
    @Override
    public void deleteRentAreaByBuildingId(Long id){
        StringBuilder sql = new StringBuilder("Delete rentarea FROM rentarea  WHERE rentarea.buildingid="+id);
        Query query = entityManager.createNativeQuery(sql.toString());
        query.executeUpdate();

    }


    @Transactional
    @Override
    public void deleteAssignmentByBuildingId(Long id){
        String sql = "Delete assignmentbuilding FROM assignmentbuilding  WHERE assignmentbuilding.buildingid="+id;
        Query query = entityManager.createNativeQuery(sql);
        query.executeUpdate();
    }

    @Override
    public int countTotalItem() {
        String sql = "SELECT * FROM building where 1=1";
        Query query = entityManager.createNativeQuery(sql);
        return query.getResultList().size();
    }


}
