package com.javaweb.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "transaction")
public class InstallmentEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "note")
    private String note;

    @Column(name = "status")
    private String status;

    @Column(name = "active")
    private int active;

    @Column(name = "amount")
    private Long amount;

    @Column(name = "duedate")
    private String duedate;

    @OneToMany(mappedBy="installments", fetch = FetchType.LAZY)
    private List<AssignmentInstallmentEntity>assignmentInstallmentEntityList = new ArrayList<>();

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<AssignmentInstallmentEntity> getAssignmentInstallmentEntityList() {
        return assignmentInstallmentEntityList;
    }

    public void setAssignmentInstallmentEntityList(List<AssignmentInstallmentEntity> assignmentInstallmentEntityList) {
        this.assignmentInstallmentEntityList = assignmentInstallmentEntityList;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getDuedate() {
        return duedate;
    }

    public void setDuedate(String duedate) {
        this.duedate = duedate;
    }
}
