package com.javaweb.repository.custom.impl;

import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.CustomerEntity;
import com.javaweb.entity.UserEntity;
import com.javaweb.model.request.CustomerSearchRequest;
import com.javaweb.model.request.UserInstallmentSearchRequest;
import com.javaweb.repository.custom.UserRepositoryCustom;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepositoryCustom {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<UserEntity> findByRole(String roleCode) {
		//JPQL
		String sql = "FROM UserEntity";
		Query query = entityManager.createNativeQuery(sql, UserEntity.class);
		return query.getResultList();
	}

	@Override
	public List<UserEntity> getAllUsers(Pageable pageable) {

		StringBuilder sql = new StringBuilder(buildQueryFilter())
				.append(" LIMIT ").append(pageable.getPageSize()).append("\n")
				.append(" OFFSET ").append(pageable.getOffset());
		System.out.println("Final query: " + sql.toString());

		Query query = entityManager.createNativeQuery(sql.toString(), UserEntity.class);
		return query.getResultList();
	}

	@Override
	public int countTotalItem() {
		String sql = buildQueryFilter();
		Query query = entityManager.createNativeQuery(sql.toString());
		return query.getResultList().size();
	}

	private String buildQueryFilter() {
		String sql = "SELECT * FROM user u WHERE u.status = 1";
		return sql;
	}

	@Override
	@Transactional
	public List<UserEntity> findUsersByBuilding(BuildingEntity buildingEntity) {
		String sql = "SELECT u.* FROM user u JOIN assignmentbuilding a ON u.id = a.staffid JOIN building b ON a.buildingid = b.id WHERE b.id ="+buildingEntity.getId() +" GROUP BY u.id";
		Query query = entityManager.createNativeQuery(sql, UserEntity.class);

		return query.getResultList();
//        List<UserEntity>userEntities = new ArrayList<>();
//        return  userEntities;
	}

	public static void joinTable(UserInstallmentSearchRequest userInstallmentSearchRequest, StringBuilder sql){
		Long buildingId = userInstallmentSearchRequest.getBuildingId();
		if (buildingId!=null) {
			sql.append("  INNER JOIN assignmentinstallment a ON c.id = a.userid INNER JOIN building b ON a.buildingid = b.id  ");
		}
	}


	@Override
	public List<UserEntity>findUserInstallment(UserInstallmentSearchRequest userInstallmentSearchRequest){
		StringBuilder sql = new StringBuilder("SELECT u.* FROM user u JOIN user_role ur ON u.id = ur.userid ");
		joinTable(userInstallmentSearchRequest, sql);
		StringBuilder where = new StringBuilder(" WHERE 1=1 ");
		if(userInstallmentSearchRequest.getBuildingId()!=null){
			Long bid = userInstallmentSearchRequest.getBuildingId();
			where.append(" AND b.id = "+bid);

		}
		if(userInstallmentSearchRequest.getFullName()!=null||userInstallmentSearchRequest.getFullName().length()>0){
			String fullName = userInstallmentSearchRequest.getFullName();
			where.append(" AND fullname LIKE '%"+fullName+"%' ");

		}
		where.append(" AND u.status=1 AND ur.role_id=3  GROUP BY u.id  ");
		sql.append(where);
		Query query = entityManager.createNativeQuery(sql.toString(), UserEntity.class);

		return query.getResultList();



	}
}
