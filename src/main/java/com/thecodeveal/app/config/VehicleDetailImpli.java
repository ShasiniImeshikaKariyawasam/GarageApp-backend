package com.thecodeveal.app.config;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class VehicleDetailImpli {

    private Long id;
    private String vehicleNum;
    private long ownerId;
    private String type;

    public VehicleDetailImpli(Long id,long ownerId,String type,String vehicleNum) {
        this.id = id;
        this.ownerId = ownerId;
        this.type = type;
        this.vehicleNum = vehicleNum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(long ownerId) {
        this.ownerId = ownerId;
    }

    public String getVehicleNum() {
        return vehicleNum;
    }

    public void setVehicleNum(String vehicleNum) {
        this.vehicleNum = vehicleNum;
    }

}
