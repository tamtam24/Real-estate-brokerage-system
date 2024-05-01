package com.javaweb.entity;

import javax.persistence.*;

@Entity
@Table(name = "assignmentcustomer")
public class AssignmentCustomerEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customerid")
    private CustomerEntity customers;

	@ManyToOne
    @JoinColumn(name = "staffid")
    private UserEntity staffs;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public CustomerEntity getCustomers() {
        return customers;
    }

    public void setCustomers(CustomerEntity customers) {
        this.customers = customers;
    }

    public UserEntity getStaffs() {
        return staffs;
    }

    public void setStaffs(UserEntity staffs) {
        this.staffs = staffs;
    }
}
