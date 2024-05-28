package com.javaweb.model.dto;

import com.javaweb.entity.AssignmentInstallmentEntity;
import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.InstallmentEntity;
import com.javaweb.entity.UserEntity;

import java.util.List;

public class Installment_Building_UserDto extends AbstractDTO {
    private Long id;
    private UserEntity staffs;
    private UserEntity users;
    private InstallmentEntity installments;
    private BuildingEntity buildings;

    @Override
    public Long getId() {
        return installments.getId();
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public UserEntity getStaffs() {
        return staffs;
    }

    public void setStaffs(UserEntity staffs) {
        this.staffs = staffs;
    }

    public UserEntity getUsers() {
        return users;
    }

    public void setUsers(UserEntity users) {
        this.users = users;
    }

    public InstallmentEntity getInstallments() {
        return installments;
    }

    public void setInstallments(InstallmentEntity installments) {
        this.installments = installments;
    }

    public BuildingEntity getBuildings() {
        return buildings;
    }

    public void setBuildings(BuildingEntity buildings) {
        this.buildings = buildings;
    }
}
