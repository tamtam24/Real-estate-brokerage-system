package com.javaweb.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="building")
public class BuildingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "street")
    private String street;

    @Column(name = "ward")
    private String ward;

    @Column(name = "district")
    private String district;

    @Column(name = "structure")
    private String structure;

    @Column(name = "numberofbasement")
    private int numberofbasement;

    @Column(name = "floorarea")
    private Long floorarea;

    @Column(name = "direction")
    private String direction;

    @Column(name = "level")
    private String level;

    @Column(name = "rentprice")
    private Long rentprice;

    @Column(name = "rentpricedescription")
    private String rentpricedescription;

    @Column(name = "servicefee")
    private String servicefee;

    @Column(name = "carfee")
    private String carfee;

    @Column(name = "motofee")
    private String motofee;

    @Column(name = "overtimefee")
    private String overtimefee;

    @Column(name = "waterfee")
    private String waterfee;

    @Column(name = "electricityfee")
    private String electricityfee;

    @Column(name = "deposit")
    private String deposit;

    @Column(name = "payment")
    private String payment;

    @Column(name = "renttime")
    private String renttime;

    @Column(name = "decorationtime")
    private String decorationtime;

    @Column(name = "brokeragefee")
    private Float brokeragefee;

    @Column(name = "note")
    private String note;

    @Column(name = "type")
    private String type;

    @Column(name = "linkofbuilding")
    private String linkofbuilding;

    @Column(name = "map")
    private String map;



    @Column(name = "image")
    private String image;
//
    @Column(name = "createddate")
    private Date createddate;

    @Column(name = "modifieddate")
    private Date modifieddate;

    @Column(name = "createdby")
    private String createdby;

    @Column(name = "modifiedby")
    private String modifiedby;

    @Column(name = "managername")
    private String managername;

    @Column(name = "managerphone")
    private String managerphone;

    @OneToMany(mappedBy="building",fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.MERGE},orphanRemoval = true)
    private List<RentAreaEntity>items = new ArrayList<>();

    public void removeRentArea(List<RentAreaEntity>rentAreaEntity){
        items.remove(rentAreaEntity);
    }

    @OneToMany(mappedBy="buildings", fetch = FetchType.LAZY)
    private List<AssignmentInstallmentEntity>assignmentInstallmentEntityList = new ArrayList<>();





//    @OneToMany(mappedBy = "building",fetch = FetchType.LAZY)
//    private  List<AssignmentBuildingEntity>assignmentBuildingEntities=new ArrayList<>();


    @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.ALL})
    @JoinTable(name = "assignmentbuilding",
            joinColumns = @JoinColumn(name = "buildingid", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "staffid", nullable = false))
    private List<UserEntity> userEntities = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getStructure() {
        return structure;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    public int getNumberofbasement() {
        return numberofbasement;
    }

    public void setNumberofbasement(int numberofbasement) {
        this.numberofbasement = numberofbasement;
    }

    public Long getFloorarea() {
        return floorarea;
    }

    public void setFloorarea(Long floorarea) {
        this.floorarea = floorarea;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Long getRentprice() {
        return rentprice;
    }

    public void setRentprice(Long rentprice) {
        this.rentprice = rentprice;
    }

    public String getRentpricedescription() {
        return rentpricedescription;
    }

    public void setRentpricedescription(String rentpricedescription) {
        this.rentpricedescription = rentpricedescription;
    }

    public String getServicefee() {
        return servicefee;
    }

    public void setServicefee(String servicefee) {
        this.servicefee = servicefee;
    }

    public String getCarfee() {
        return carfee;
    }

    public void setCarfee(String carfee) {
        this.carfee = carfee;
    }

    public String getMotofee() {
        return motofee;
    }

    public void setMotofee(String motofee) {
        this.motofee = motofee;
    }

    public String getOvertimefee() {
        return overtimefee;
    }

    public void setOvertimefee(String overtimefee) {
        this.overtimefee = overtimefee;
    }

    public String getElectricityfee() {
        return electricityfee;
    }

    public void setElectricityfee(String electricityfee) {
        this.electricityfee = electricityfee;
    }

    public String getDeposit() {
        return deposit;
    }

    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getRenttime() {
        return renttime;
    }

    public void setRenttime(String renttime) {
        this.renttime = renttime;
    }

    public String getDecorationtime() {
        return decorationtime;
    }

    public void setDecorationtime(String decorationtime) {
        this.decorationtime = decorationtime;
    }

    public Float getBrokeragefee() {
        return brokeragefee;
    }

    public void setBrokeragefee(Float brokeragefee) {
        this.brokeragefee = brokeragefee;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getCreateddate() {
        return createddate;
    }

    public void setCreateddate(Date createddate) {
        this.createddate = createddate;
    }

    public Date getModifieddate() {
        return modifieddate;
    }

    public void setModifieddate(Date modifieddate) {
        this.modifieddate = modifieddate;
    }

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    public String getModifiedby() {
        return modifiedby;
    }

    public void setModifiedby(String modifiedby) {
        this.modifiedby = modifiedby;
    }

    public String getManagername() {
        return managername;
    }

    public void setManagername(String managername) {
        this.managername = managername;
    }

    public String getManagerphone() {
        return managerphone;
    }

    public void setManagerphone(String managerphone) {
        this.managerphone = managerphone;
    }

    public List<RentAreaEntity> getItems() {
        return items;
    }

    public void setItems(List<RentAreaEntity> items) {
        this.items = items;
    }

    public List<UserEntity> getUserEntities() {
        return userEntities;
    }

    public void setUserEntities(List<UserEntity> userEntities) {
        this.userEntities = userEntities;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<AssignmentInstallmentEntity> getAssignmentInstallmentEntityList() {
        return assignmentInstallmentEntityList;
    }

    public void setAssignmentInstallmentEntityList(List<AssignmentInstallmentEntity> assignmentInstallmentEntityList) {
        this.assignmentInstallmentEntityList = assignmentInstallmentEntityList;
    }

    //    @ManyToOne
//    @JoinColumn (name="districtid")
//    private DistrictEntity district;
//
//    @OneToMany(mappedBy="building",fetch = FetchType.LAZY)
//    private List<rentareaEntity>items = new ArrayList<>();

//


}