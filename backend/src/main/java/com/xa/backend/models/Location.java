package com.xa.backend.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "location")
public class Location {
    
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long Id;

    @Column(name = "name", length = 100)
    private String Name;

    @Column(name = "parent_id")
    private Long parentId;

    @ManyToOne
    @JoinColumn(name="parent_id", insertable = false, updatable = false)
    public Location location;

    @Column(name = "location_level_id", length = 100)
    private Long locationLevelId;

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

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Long getLocationLevelId() {
        return locationLevelId;
    }

    public void setLocationLevelId(Long locationLevelId) {
        this.locationLevelId = locationLevelId;
    }
    
}
