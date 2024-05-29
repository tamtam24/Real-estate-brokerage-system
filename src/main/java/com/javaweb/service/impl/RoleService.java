package com.javaweb.service.impl;

import com.javaweb.converter.RoleConverter;
import com.javaweb.model.dto.RoleDTO;
import com.javaweb.entity.RoleEntity;
import com.javaweb.repository.RoleRepository;
import com.javaweb.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RoleService implements IRoleService {
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private RoleConverter roleConverter;

	public List<RoleDTO> findAll() {
		List<RoleEntity> roleEntities = roleRepository.findAll();
		List<RoleDTO> list = new ArrayList<>();
		roleEntities.forEach(item -> {
			RoleDTO roleDTO = roleConverter.convertToDto(item);
			list.add(roleDTO);
		});
		return list;
	}

	@Override
	public Map<String, String> getRoles() {
		Map<String,String> roleTerm = new HashMap<>();
		List<RoleEntity> roleEntity = roleRepository.findAll();
		for(RoleEntity item : roleEntity){
			RoleDTO roleDTO = roleConverter.convertToDto(item);
			roleTerm.put(roleDTO.getCode(), roleDTO.getName());
		}
		return roleTerm;
	}
}
