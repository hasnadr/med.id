package com.xa.miniproject313_api.models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "m_bank")
public class Bank {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long Id;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "va_code", length = 10)
    private String vaCode;

    @ManyToOne
    @JoinColumn(name = "created_by", insertable = false, updatable = false)
    public User userCreatedBy;

    @Column(name = "created_by")
    private Long createdBy;

    @ManyToOne
    @JoinColumn(name = "modified_by", insertable = false, updatable = false)
    public User userModifiedBy;

    @Column(name = "modified_by")
    private Long modifiedBy;

    @ManyToOne
    @JoinColumn(name = "deleted_by", insertable = false, updatable = false)
    public User userDeletedBy;

    @Column(name = "deleted_by")
    private Long deletedBy;

    @Column(name = "created_on")
    private Timestamp createdOn;

    @Column(name = "modified_on")
    private Timestamp modifiedOn;

    @Column(name = "deleted_on")
    private Timestamp deletedOn;

    @Column(name = "is_deleted", columnDefinition = "boolean default false")
    private boolean isDeleted;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVaCode() {
        return vaCode;
    }

    public void setVaCode(String vaCode) {
        this.vaCode = vaCode;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Long getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Long modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Long getDeletedBy() {
        return deletedBy;
    }

    public void setDeletedBy(Long deletedBy) {
        this.deletedBy = deletedBy;
    }

    public Timestamp getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Timestamp createdOn) {
        this.createdOn = createdOn;
    }

    public Timestamp getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(Timestamp modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public Timestamp getDeletedOn() {
        return deletedOn;
    }

    public void setDeletedOn(Timestamp deletedOn) {
        this.deletedOn = deletedOn;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public User getUserCreatedBy() {
        return userCreatedBy;
    }

    public void setUserCreatedBy(User userCreatedBy) {
        this.userCreatedBy = userCreatedBy;
    }

    public User getUserModifiedBy() {
        return userModifiedBy;
    }

    public void setUserModifiedBy(User userModifiedBy) {
        this.userModifiedBy = userModifiedBy;
    }

    public User getUserDeletedBy() {
        return userDeletedBy;
    }

    public void setUserDeletedBy(User userDeletedBy) {
        this.userDeletedBy = userDeletedBy;
    }

}
