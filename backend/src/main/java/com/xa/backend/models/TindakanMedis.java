package com.xa.backend.models;


import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "t_doctor_treatment")
public class TindakanMedis {
    
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long Id;

    @Column(name = "doctor_id")
    private Long doctorId;

    @ManyToOne
    @JoinColumn(name="doctor_id", insertable = false, updatable = false)
    public Doctor doctor;

    @Column(name = "name", length = 50)
    private String Name;

    @Column(name = "created_by")
    private Long createdBy;

    @ManyToOne
    @JoinColumn(name="created_by", insertable = false, updatable = false)
    public User userCreated;

    @NotNull
    @Column(name = "created_on")
    private Timestamp createdOn;

    @Column(name = "modified_by")
    private Long modifiedBy;

    @ManyToOne
    @JoinColumn(name="modified_by", insertable = false, updatable = false)
    public User userModified;

    @Column(name = "modified_on")
    private Timestamp modifiedOn;

    @Column(name = "deleted_by")
    private Long deletedBy;

    @ManyToOne
    @JoinColumn(name="deleted_by", insertable = false, updatable = false)
    public User userDeleted;

    @Column(name = "deleted_on")
    private Timestamp deletedOn;

    @Column(name="is_delete", columnDefinition = "boolean default false")
    private Boolean Deleted;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public User getUserCreated() {
        return userCreated;
    }

    public void setUserCreated(User userCreated) {
        this.userCreated = userCreated;
    }

    public Timestamp getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Timestamp createdOn) {
        this.createdOn = createdOn;
    }

    public Long getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Long modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public User getUserModified() {
        return userModified;
    }

    public void setUserModified(User userModified) {
        this.userModified = userModified;
    }

    public Timestamp getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(Timestamp modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public Long getDeletedBy() {
        return deletedBy;
    }

    public void setDeletedBy(Long deletedBy) {
        this.deletedBy = deletedBy;
    }

    public User getUserDeleted() {
        return userDeleted;
    }

    public void setUserDeleted(User userDeleted) {
        this.userDeleted = userDeleted;
    }

    public Timestamp getDeletedOn() {
        return deletedOn;
    }

    public void setDeletedOn(Timestamp deletedOn) {
        this.deletedOn = deletedOn;
    }

    public Boolean getDeleted() {
        return Deleted;
    }

    public void setDeleted(Boolean deleted) {
        Deleted = deleted;
    }
}
