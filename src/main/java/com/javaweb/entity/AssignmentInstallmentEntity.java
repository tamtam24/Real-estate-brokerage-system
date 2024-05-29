package com.javaweb.entity;

import javax.persistence.*;

@Entity
@Table(name = "assignmentinstallment")
public class AssignmentInstallmentEntity extends  BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "staffid")
    private  UserEntity staffs;

    @ManyToOne
    @JoinColumn(name = "userid")
    private UserEntity users;

    @ManyToOne
    @JoinColumn(name = "installmentid")
    private InstallmentEntity installments;

    @ManyToOne
    @JoinColumn(name = "buildingid")
    private BuildingEntity buildings;

    @Override
    public Long getId() {
        return id;
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
