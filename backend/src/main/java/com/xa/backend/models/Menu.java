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
@Table(name = "m_menu")
public class Menu {
    
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long Id;

    @Column(name = "name", length = 20)
    private String Name;

    @Column(name = "url", length = 50)
    private String Url;

    @Column(name = "parent_id")
    private Long parentId;

    @ManyToOne
    @JoinColumn(name="parent_id", insertable = false, updatable = false)
    public Menu menu;
    
    @Column(name = "big_icon", length = 100)
    private String bigIcon;

    @Column(name = "small_icon", length = 100)
    private String smallIcon;

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

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public String getBigIcon() {
        return bigIcon;
    }

    public void setBigIcon(String bigIcon) {
        this.bigIcon = bigIcon;
    }

    public String getSmallIcon() {
        return smallIcon;
    }

    public void setSmallIcon(String smallIcon) {
        this.smallIcon = smallIcon;
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
