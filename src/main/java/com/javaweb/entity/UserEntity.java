package com.javaweb.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class UserEntity extends BaseEntity {

    private static final long serialVersionUID = -4988455421375043688L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false, unique = true)
    private String userName;

    @Column(name = "fullname", nullable = false)
    private String fullName;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "status", nullable = false)
    private Integer status;

    @Column(name = "email", unique = true)
    private String email;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "role_id", nullable = false))
    private List<RoleEntity> roles = new ArrayList<>();

    @ManyToMany(mappedBy = "userEntities", fetch = FetchType.LAZY,cascade = {CascadeType.REMOVE})
    List<BuildingEntity>buildingEntityList = new ArrayList<>();

    @ManyToMany(mappedBy = "staffs", fetch = FetchType.LAZY,cascade = {CascadeType.REMOVE})
    List<CustomerEntity>customers = new ArrayList<>();

    @OneToMany(mappedBy="staffs", fetch = FetchType.LAZY)
    private List<AssignmentInstallmentEntity>assignmentInstallmentEntityListstaff = new ArrayList<>();

    @OneToMany(mappedBy="users", fetch = FetchType.LAZY)
    private List<AssignmentInstallmentEntity>assignmentInstallmentEntityListuser = new ArrayList<>();

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<RoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleEntity> roles) {
        this.roles = roles;
    }

    public List<BuildingEntity> getBuildingEntityList() {
        return buildingEntityList;
    }

    public void setBuildingEntityList(List<BuildingEntity> buildingEntityList) {
        this.buildingEntityList = buildingEntityList;
    }

    public List<CustomerEntity> getCustomers() {
        return customers;
    }

    public void setCustomers(List<CustomerEntity> customers) {
        this.customers = customers;
    }

    public List<AssignmentInstallmentEntity> getAssignmentInstallmentEntityListstaff() {
        return assignmentInstallmentEntityListstaff;
    }

    public void setAssignmentInstallmentEntityListstaff(List<AssignmentInstallmentEntity> assignmentInstallmentEntityListstaff) {
        this.assignmentInstallmentEntityListstaff = assignmentInstallmentEntityListstaff;
    }

    public List<AssignmentInstallmentEntity> getAssignmentInstallmentEntityListuser() {
        return assignmentInstallmentEntityListuser;
    }

    public void setAssignmentInstallmentEntityListuser(List<AssignmentInstallmentEntity> assignmentInstallmentEntityListuser) {
        this.assignmentInstallmentEntityListuser = assignmentInstallmentEntityListuser;
    }

    ////    @OneToMany(mappedBy = "staffs",fetch = FetchType.LAZY)
////    private  List<AssignmentBuildingEntity>assignmentBuildingEntities=new ArrayList<>();
//
//
////    @OneToMany(mappedBy="staffs", fetch = FetchType.LAZY)
////    private List<AssignmentBuildingEntity> assignmentBuildingEntities = new ArrayList<>();
////
////    @OneToMany(mappedBy="users", fetch = FetchType.LAZY)
////    private List<UserRoleEntity> userRoleEntities = new ArrayList<>();
//
//    public static long getSerialVersionUID() {
//        return serialVersionUID;
//    }
//
//
//    public String getUserName() {
//        return userName;
//    }
//
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }
//
//    public String getFullName() {
//        return fullName;
//    }
//
//    public void setFullName(String fullName) {
//        this.fullName = fullName;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public Integer getStatus() {
//        return status;
//    }
//
//    public void setStatus(Integer status) {
//        this.status = status;
//    }
//
//    public List<RoleEntity> getRoles() {
//        return roles;
//    }
//
//    public void setRoles(List<RoleEntity> roles) {
//        this.roles = roles;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//
//

//    @Override
//    public Long getId() {
//        return id;
//    }
//
//    @Override
//    public void setId(Long id) {
//        this.id = id;
//    }
}
