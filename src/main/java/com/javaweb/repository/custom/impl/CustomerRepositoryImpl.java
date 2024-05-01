package com.javaweb.repository.custom.impl;

import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.CustomerEntity;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.model.request.CustomerSearchRequest;
import com.javaweb.repository.custom.CustomerRepositoryCustom;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.lang.reflect.Field;
import java.util.List;

@Repository
public class CustomerRepositoryImpl implements CustomerRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    public static void joinTable(CustomerSearchRequest customerSearchRequest, StringBuilder sql){
        Long staffId = customerSearchRequest.getStaffid();
        if (staffId!=null) {
            sql.append("  INNER JOIN assignmentcustomer a ON c.id = a.customerid ");
        }
    }
    public static void queryNormal(CustomerSearchRequest customerSearchRequest, StringBuilder where) {


        try {

            Field[]fields = customerSearchRequest.getClass().getDeclaredFields();
            for(Field item:fields) {
                item.setAccessible(true);
                String fieldName=item.getName();
                if (!fieldName.equals("staffid")) {
                    Object value = item.get(customerSearchRequest);
                    if (value!=null && value !="") {
                        if (item.getType().getName().equals("java.lang.Long")||item.getType().getName().equals("java.lang.Integer")||item.getType().getName().equals("java.lang.Float")) {
                            where.append(" AND c." + fieldName + " = " + value);
                        } else if(item.getType().getName().equals("java.lang.String")) {
                            where.append(" AND c." + fieldName+ " LIKE '%" + value + "%' ");
                        }
                    }

                }
            }
        }catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    public static void queryStaffId(CustomerSearchRequest customerSearchRequest,StringBuilder where){
        Long staffId = customerSearchRequest.getStaffid();
        if(staffId != null){
            where.append(" AND a.staffid = "+staffId+" ");
        }
    }


    @Override
    public List<CustomerEntity> findCustomers (CustomerSearchRequest customerSearchRequest, Pageable pageable) {
        StringBuilder sql = new StringBuilder("SELECT c.* FROM customer c  ");
        joinTable(customerSearchRequest, sql);
        StringBuilder where = new StringBuilder(" WHERE 1=1 ");
        queryNormal(customerSearchRequest, where);
        queryStaffId(customerSearchRequest,where);
        where.append(" AND c.is_active=1 ");
        where.append(" GROUP BY c.id  ");
        if (pageable != null) {
            int t = pageable.getPageSize();
            Long m = pageable.getOffset();
            sql.append(where).append(" LIMIT "+ t) .append(" OFFSET "+ m );
        } else {
            sql.append(where);
        }
        sql.append(" ; ");
        Query query = entityManager.createNativeQuery(sql.toString(), CustomerEntity.class);

        return query.getResultList();


    }

    public int countTotalItem(){
        String sql = "Select * from customer where customer.is_active=1";
        Query query = entityManager.createNativeQuery(sql);
        return query.getResultList().size();
    }



}
